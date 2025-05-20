package za.ac.cput;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Course course = CourseFactory.create(301, "App Development 3", 100, 3, new ArrayList<>(), new ArrayList<>());

        StudentRepository studentRepository = StudentRepository.getRepository();
        Student student1 = StudentFactory.create("1", "Preben", "Krishna", LocalDate.of(1990, 1, 1), course, true);
        Student student2 = StudentFactory.create("2", "Mike", "Jones", LocalDate.of(1995, 1, 1), course, true);
        studentRepository.create(student1);
        studentRepository.create(student2);

        StudentRepository studentRepository2 = StudentRepository.getRepository();
        System.out.println("Student Repository 1:");
        System.out.println(studentRepository.getAll());
        System.out.println("Student Repository 2:");
        System.out.println(studentRepository2.getAll());

        for (int i = 0; i < studentRepository.getAll().size(); i++) {
            if (studentRepository2.getAll().get(i).getId().equals(studentRepository2.getAll().get(i).getId()))
            {
                System.out.println("The two repositories match");
            }
            else {
                System.out.println("The two repositories do not match");
            }
        }


    }

}
