package za.ac.cput.domian;

import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class Student {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Course course;


    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }

    public String getId() {

        return id;
    }

    public Course getCourse() {
        return course;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", course=" + course.getName() +
                '}';
    }

    private Student(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.course = builder.course;

    }


    public static class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private Course course;


        public Builder setId(String id) {
            if (Helper.Validate.isString(id)) {
                this.id = id;
            }
            return this;
        }

        public Builder setFirstName(String firstName) {
            if (Helper.Validate.isString(firstName)) {
                this.firstName = firstName;
            }
            return this;
        }

        public Builder setLastName(String lastName) {
            if (Helper.Validate.isString(lastName)) {
                this.lastName = lastName;
            }
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            if (Helper.Validate.age(dateOfBirth)) {
                this.dateOfBirth = dateOfBirth;
            }
            return this;
        }

        public Builder setCourse(Course course) {
            this.course = course;
            return this;
        }

        public Student build() {

            return new Student(this);
        }


    }

}


