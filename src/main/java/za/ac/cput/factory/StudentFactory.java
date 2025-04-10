package za.ac.cput.factory;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;

import java.time.LocalDate;

public class StudentFactory {

    public static Student create(String id, String firstName, String lastName, LocalDate dateOfBirth, Course course, boolean status) {
        // validation here

        return new Student.Builder()
                .setId(id)
                .setDateOfBirth(dateOfBirth)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCourse(course)
                .setActive(status)
                .build();

    }

    public static Student copy(Student student) {
        // validation here
        return new Student.Builder()
                .copy(student)
                .build();
    }

    public static Student createNoName(String id, LocalDate dateOfBirth, Course course) {

        // validation here
        return new Student.Builder()
                .setId(id)
                .setDateOfBirth(dateOfBirth)
                .setCourse(course)
                .build();
    }


}
