package za.ac.cput;

import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.CourseRepository;
import za.ac.cput.repository.JanitorRepository;
import za.ac.cput.repository.StudentRepository;
import za.ac.cput.util.Helper;

import java.util.ArrayList;


public class MainOld {
    public static void main(String[] args) {

        System.out.println("\r======================= Course Stuff ==============================");

        CourseRepository courseRepository = CourseRepository.getRepository();
        Course course = CourseFactory.create(1, "Diploma - Application Development", 100, 30, new ArrayList<>(), new ArrayList<>());
        Course course2 = CourseFactory.create(2, "Diploma - Networking", 100, 30, new ArrayList<>(), new ArrayList<>());
        Course course3 = CourseFactory.create(3, "Diploma - Multimedia", 100, 30, new ArrayList<>(), new ArrayList<>());
        //we want  the student repo to be created

        //StudentRepository studentRepository = new StudentRepository();
        StudentRepository studentRepository = StudentRepository.getRepository();

        //We want to create a students via the factory
        Student student = StudentFactory.create("1", "Kamva", "krishna", Helper.Dates.generateDateOfBirthForAdult(), course, true);
        Student student2 = StudentFactory.create("2", "Mike", "Jones", Helper.Dates.generateDateOfBirthForAdult(), course2, true);
        System.out.println("student name : " + student.getFirstName() + "student age: " + student.getAge());

        //We want to add the students to the repository
        studentRepository.create(student); //one element in the arraylist
        studentRepository.create(student2);//two elements in the arraylist

        System.out.println(studentRepository.read("1"));

        //we want see what is in the repository at this point
        System.out.println(studentRepository.getAll());

        //we want to remove a student from the repository
        System.out.println("del student : " + studentRepository.delete("1"));
        System.out.println(studentRepository.getAll()); //after deleting the student with the id on 1 for example
        System.out.println(Helper.IDGenerator.generateUUID());


        System.out.println("======================= Janitor Stuff ==============================");

        JanitorRepository janitorRepository = JanitorRepository.getRepository();
        Janitor janitor = JanitorFactory.create("1", "Jack", "Smith", "5000");

        Janitor janitor2 = JanitorFactory.create("2", "Bilal", " Khan", "1001");

        janitorRepository.create(janitor);
        janitorRepository.create(janitor2);
        System.out.println(janitorRepository.read("1"));
        System.out.println(janitorRepository.getAll());
        System.out.println("del janitor : " + janitorRepository.delete("1"));

        System.out.println(janitorRepository.getAll());

        System.out.println("\n");
        System.out.println("\r======================= Employee Stuff ==============================");
        Groundskeeper groundskeeper = new Groundskeeper.Builder().setId("1").setFirstName("Groundskeeper-1-FN").setLastName("Groundskeeper-LN").setGroundsKeeperNumber(9001).build();
        System.out.println("\t");
        System.out.println(groundskeeper.toString());

        course.addStudent(student);
        Subject subject = SubjectFactory.create("1", "Application Development Practice 3", 1, new ArrayList<>());
        Lecturer lecturer = LecturerFactory.create("1", "Mike", "Jones", "ITmike@cput.ac.za", "IT", new ArrayList<>());
        lecturer.addSubject(subject);
        subject.addLecturer(lecturer);
        course.addSubject(subject);
        course2.addStudent(student2);
        courseRepository.create(course);
        courseRepository.create(course2);
        courseRepository.create(course3);
        System.out.println(courseRepository.read(1));
        System.out.println(courseRepository.getAll());
        System.out.println(courseRepository.delete(1));
        System.out.println(courseRepository.getAll());

        Student student3 = StudentFactory.create("3", "Kamva", "krishna", Helper.Dates.generateDateOfBirthForAdult(), course, true);
        Student student4 = StudentFactory.createNoName("4", Helper.Dates.generateDateOfBirthForAdult(), course2);
        System.out.println(student4.toString());


    }

}