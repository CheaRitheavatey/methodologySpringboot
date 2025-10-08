
@JsonSerilizable
public class CreateAnnotation {

    @JsonElement(key = "firstName")
    private String firstName;

    @JsonElement(key = "lastName")
    private String lastName;

    private String addresss;

    // constructor
    CreateAnnotation(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Init
    private void initName() {
        this.firstName = this.firstName.substring(0,1).toUpperCase() + this.firstName.substring(1).toLowerCase();
        this.lastName = this.lastName.substring(0,1).toUpperCase() + this.lastName.substring(1).toLowerCase();
    }
}
