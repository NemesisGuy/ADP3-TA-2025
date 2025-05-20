package za.ac.cput.domain;

import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class Student {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Course course;
    private final boolean isActive; //now u could have a status of active or inactive or expired or expelled. /// store in a Enum

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }

    public int getAge() {

        return Helper.Dates.getAge(dateOfBirth);
    }

    public String getId() {

        return id;
    }

    public boolean isActive() {
        return isActive;
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
                ", isActive=" + isActive +
                '}';
    }


    private Student(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.course = builder.course;
        this.isActive = builder.isActive;

    }


    public static class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private Course course;
        private boolean isActive;


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

        public Builder setActive(boolean active) {
            isActive = active;
            return this;
        }

        // Copy, used to create a new object with the same values as an existing one.
        // This is useful for creating a new object based on an existing one, while still allowing for modifications.
        public Builder copy(Student student) {
            this.id = student.id;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.dateOfBirth = student.dateOfBirth;
            this.course = student.course;
            this.isActive = student.isActive;
            return this;
        }

        // This method is used to create a new object of the same type as the current object.
        // We call the private constructor to create a new object. (Builder magic)
        public Student build() {

            //validate the object here

            return new Student(this);
        }


    }

}


