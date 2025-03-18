package za.ac.cput.domian;

import za.ac.cput.util.Helper;

import java.util.List;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private Course course;
    private List <Subject> subjects;


    public String getFirstName() {

        return firstName;
    }
    public String getLastName() {

        return lastName;
    }

    public int getAge() {

        return age;
    }

    public String getId() {

        return id;
    }

    public Course getCourse() {
        return course;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", course=" + course +
                ", subjects=" + subjects +
                '}';
    }

    private Student(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.course = builder.course;
        this.subjects = builder.subjects;
    }



    public static class Builder{
        private String id;
        private String firstName;
        private String lastName;
        private int age;
        private Course course;
        private List <Subject> subjects;


        public Builder setId(String id) {
            if (Helper.Validate.isString(id))
            {
                this.id = id;
            }
            return this;
        }
        public Builder setFirstName(String firstName) {
            if(Helper.Validate.isString(firstName))
            {
                this.firstName = firstName;
            }
            return this;
        }
        public Builder setLastName(String lastName) {
            if(Helper.Validate.isString(lastName))
            {
                this.lastName = lastName;
            }
            return this;
        }
        public  Builder setAge(int age) {
            if (Helper.Validate.age(age))
            {
                this.age = age;
            }
            return this;
        }

        public void setCourse(Course course) {
            this.course = course;
        }
        public  Builder setSubjects(List <Subject> subjects) {
            this.subjects = subjects;
            return this;
        }
        public Student build() {

            return new Student(this);
        }


    }

}


