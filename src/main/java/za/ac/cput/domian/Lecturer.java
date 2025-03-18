package za.ac.cput.domian;
// CONVERTING TO BUILDER PATTERN
    //Private constructor
    //inner public static Builder class
       // private attributes
         // public setters
            // public build method -- call private constructor in return

import za.ac.cput.util.Helper;


import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Employee{

    private String email;
    private String qualification;

    private List<Subject> subjects;

    private Lecturer(Builder builder) {
    super(builder);
        this.email = builder.email;
        this.qualification = builder.qualification;
        this.subjects = new ArrayList<>();

    }
    //get....setters for pojo

    // then we move the setters to the inner builder class

    public String getEmail() {return email;}
    public String getQualification() {
        return qualification;
    }
    public  List<Subject> getSubjects() {
        return subjects;
    }

    public  void addSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id='" + id + '\'' +
                ", name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    public static class Builder extends Employee.Builder<Builder>{
//        private String id;
//        private String firstName;
//        private String lastName;

        private String email;
        private String qualification;
        private  List<Subject> subjects;

        public Builder setId(String id){
            if (Helper.Validate.isString(id))
            {
                this.id = id;
            }
            return this;
        }
        public Builder setFirstName(String firstName){
            if (Helper.Validate.isString(firstName)){
                this.firstName = firstName;
            }
            return this;
        }
        public Builder setLastName(String lastName){
            if (Helper.Validate.isString(lastName)){
                this.lastName = lastName;
            }
            return this;
        }
        public Builder setSubjects(List<Subject> subjects){
            this.subjects = subjects;
            return this;
        }

        @Override
        protected Builder self() {
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
            this.firstName = lecturer.firstName;
            this.lastName = lecturer.lastName;
            this.email = lecturer.email;
            this.qualification = lecturer.qualification;
            this.subjects = lecturer.subjects;
            return this;
        }
    }


}


