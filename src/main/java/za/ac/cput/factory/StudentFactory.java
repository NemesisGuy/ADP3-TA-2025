package za.ac.cput.factory;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.StudentDTO;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class StudentFactory implements IFactory {
    @Override
    public <T> T Create() {
        return null;
    }
    // Factory method for creating a Student object
    public static Student create(StudentDTO studentDTO) {
        // validation here
        return new Student.Builder()
                .setId(studentDTO.getId())
                .setDateOfBirth(studentDTO.getDateOfBirth())
                .setFirstName(studentDTO.getFirstName())
                .setLastName(studentDTO.getLastName())
                .setCourse(studentDTO.getCourse())
                .setActive(studentDTO.isActive())
                .build();
    }

    // Factory method for creating a Student object
    public static Student create(String id, String firstName, String lastName, LocalDate dateOfBirth, Course course, boolean status) {
        // Validation here
        if (Helper.Validate.isNotNull(id) && Helper.Validate.isString(id) &&
                Helper.Validate.isNotNull(firstName) && Helper.Validate.isString(firstName) &&
                Helper.Validate.isNotNull(lastName) && Helper.Validate.isString(lastName) &&
                Helper.Validate.isNotNull(dateOfBirth) && Helper.Validate.age(dateOfBirth) &&
                Helper.Validate.isNotNull(course))
        {
            return new Student.Builder()
                    .setId(id)
                    .setDateOfBirth(dateOfBirth)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setCourse(course)
                    .setActive(status)
                    .build();
        }
        return null;

    }
    public static Student createJustNames(String id, String firstName, String lastName) {
        // validation here





        return new Student.Builder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }


    //Example of a Factory method calling builder to create a student without a name
    public static Student createNoName(String id, LocalDate dateOfBirth, Course course) {
        // validation here




        return new Student.Builder()
                .setId(id)
                .setDateOfBirth(dateOfBirth)
                .setCourse(course)
                .build();
    }

}
