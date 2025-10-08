import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// how long its going to be kept
//@Retention(RetentionPolicy.SOURCE) // compile time hint tool
//@Retention(RetentionPolicy.CLASS)  // .class -> analyze byteode  -> build
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {
}
