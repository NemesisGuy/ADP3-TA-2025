package za.ac.cput.util;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Lecturer;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Subject;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.factory.LecturerFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.factory.SubjectFactory;
import za.ac.cput.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class DummyMakeData {
    public static void makeData() {
        Course course = CourseFactory.create(301, "App Development 3", 100, 3, new ArrayList<>(), new ArrayList<>());

        Subject subject = SubjectFactory.create("1", "Application Development Practice 3", 1, new ArrayList<>());
        Lecturer lecturer = LecturerFactory.create("1", "Mike", "Jones", "ITmike@cput.ac.za", "Masters - IT", new ArrayList<>());
        Lecturer lecturer2 = LecturerFactory.create("2", "Boniface", "Kabaso", "JohnSmith@cput.ac.za", "PHD - APP DEV", new ArrayList<>());
        Subject subject2 = SubjectFactory.create("2", "Application Development Theory 3", 1, new ArrayList<>());
        lecturer2.addSubject(subject2);
        subject2.addLecturer(lecturer2);

        lecturer.addSubject(subject);
        subject.addLecturer(lecturer);
        course.addSubject(subject);
        course.addSubject(subject2);

        StudentRepository studentRepository = StudentRepository.getRepository();
        Student student1 = StudentFactory.create("1", "Preben", "Krishna", LocalDate.of(1990, 1, 1), course, true);
        Student student2 = StudentFactory.create("2", "Mike", "Jones", LocalDate.of(1995, 1, 1), course, true);
        studentRepository.create(student1);
        studentRepository.create(student2);
    }
}
