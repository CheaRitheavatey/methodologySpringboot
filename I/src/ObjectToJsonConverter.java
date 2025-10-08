import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {
    private void checkIsSerializanle(Object object) {
        if (Objects.isNull(object)) {
            throw new RuntimeException("object is null");
        }

        Class clas = object.getClass(); // return the runtime class of obj

        // check if its annotated or not
        if (!clas.isAnnotationPresent(JsonSerilizable.class)) {
            throw new RuntimeException("the class: " + clas.getSimpleName() + " is not annotated with jsonserializable");
        }


    }

    // inital the object
    private void initalizeObject(Object object) throws Exception{
        // get class belong to
        Class clas = object.getClass();

        // check whats inside this class and see if the annotation exist or not
        for (Method method: clas.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                // because the init is private so we need to set it to true first
                method.setAccessible(true);
                method.invoke(object); // after set to accessible, we invoke it
            }
        }
    }

    private String getJsonString(Object object) throws Exception{
        Class clas = object.getClass();

        Map<String, String> jsonelementMap = new HashMap<>();

        for (Field field: clas.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonelementMap.put(field.getAnnotation(JsonElement.class).key(), (String) field.get(object));
            }
        }

        // lamda
        String jsonString = jsonelementMap.entrySet().stream().map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(",\n"));

        // without using lamda
//        String jsonString1 = "";
//        for (Map.Entry<String, String> entry : jsonelementMap.entrySet()) {
//            if (!jsonString1.isEmpty()) {
//                jsonString1 += ", \n";
//            }
//
//            jsonString1 += "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"";
//        }

        return "{\n" + jsonString + "\n}";
    }

    public String convertToJson(Object object) throws Exception {
        try {
            checkIsSerializanle(object);
            initalizeObject(object);
            return getJsonString(object);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception{
        CreateAnnotation person = new CreateAnnotation("John", "Joe");
        ObjectToJsonConverter objectToJsonConverter = new ObjectToJsonConverter();

        System.out.println(objectToJsonConverter.convertToJson(person));

    }
}
