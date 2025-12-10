package Practice;

public class Student {
    // required
    private String name;
    private String email;
    private String major;
    private int age;

    // constructor
    public Student(StudentBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.major = builder.major;
        this.age = builder.age;
    }

    // getter and setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // builder class nested inside this class
    public static class StudentBuilder {
        private String name;
        private String email;
        private String major;
        private int age;

        // constructor
        public StudentBuilder() {}
        public StudentBuilder(String name, String email, String major, int age) {
            this.name = name;
            this.email = email;
            this.major = major;
            this.age = age;
        }

        // getter and setter

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getMajor() {
            return major;
        }

        public StudentBuilder setMajor(String major) {
            this.major = major;
            return this;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Student build() throws InvalidStudentException{
            return new Student(this);
        }
    }
}
