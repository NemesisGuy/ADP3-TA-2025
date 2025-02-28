package za.ac.cput.domian;
// CONVERTING TO BUILDER PATTERN
    //Private constructor
    //inner public static Builder class
       // private attributes
         // public setters
            // public build method -- call private constructor in return

public class Lecturer {
    private String id;
    private String name;
    private String lastName;
    private String qualification;

    private Lecturer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.qualification = builder.qualification;
    }
    //get..setters

    public String getId() {
        return id;
    }

    public String getQualification() {
        return qualification;
    }

    public String getLastName() {
        return lastName;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Lecturer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
    public static class Builder{
        private String id;
        private String name;
        private String lastName;
        private String qualification;

        public Builder setId(String id){
            this.id = id;
            return this;

        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder setQualification(String qualification){
            this.qualification = qualification;
            return this;
        }
        public Lecturer build(){

            return new Lecturer(this);
        }
        public Builder copy(Lecturer lecturer){
            this.id = lecturer.id;
            this.name = lecturer.name;
            this.lastName = lecturer.lastName;
            this.qualification = lecturer.qualification;
            return this;
        }
    }


}


