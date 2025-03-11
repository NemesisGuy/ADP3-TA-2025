package za.ac.cput.domian;
// CONVERTING TO BUILDER PATTERN
    //Private constructor
    //inner public static Builder class
       // private attributes
         // public setters
            // public build method -- call private constructor in return

import za.ac.cput.util.Helper;

public class Lecturer {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String qualification;

    private Lecturer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.qualification = builder.qualification;

    }
    //get....setters for pojo

    // then we move the setters to the inner builder class

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {return email;}
    public String getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    public static class Builder{
        private String id;
        private String name;
        private String lastName;
        private String email;
        private String qualification;

        public Builder setId(String id){
            if (Helper.Validate.isString(id))
            {
                this.id = id;
            }
            return this;
        }
        public Builder setName(String name){
            if (Helper.Validate.isString(name)){
                this.name = name;
            }
            return this;
        }
        public Builder setLastName(String lastName){
            if (Helper.Validate.isString(lastName)){
                this.lastName = lastName;
            }
            return this;
        }
        public Builder setEmail(String email){
            if (Helper.Validate.email(email))
            {
                this.email = email;
            }
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
            this.email = lecturer.email;
            this.qualification = lecturer.qualification;
            return this;
        }
    }


}


