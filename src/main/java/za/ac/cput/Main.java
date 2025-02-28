package za.ac.cput;


import za.ac.cput.domian.Cleaner;
import za.ac.cput.domian.Course;
import za.ac.cput.domian.Lecturer;
import za.ac.cput.domian.Student;
import za.ac.cput.factory.CleanerFactory;
import za.ac.cput.factory.CoursesFactory;
import za.ac.cput.factory.LecturerFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.util.Helper;
import za.ac.cput.util.IDGenerator;

import java.math.BigInteger;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Course course = CoursesFactory.createCourse(1, "Project 3", 20, 20);
        Course course2 = CoursesFactory.createCourse(2, "ADP 3", 30, 30);
        Course course3 = CoursesFactory.createCourse(IDGenerator.generateIntId(), "PROJ MAN 3", 40, 30);
        Course course4 = CoursesFactory.createCourse(IDGenerator.generateIntId(), " ADT 3 ", 40, 30);
        Course course5 = CoursesFactory.createCourse(Helper.generateIntID(), "Prof Dev 3" , 40, 30);

        Student student = StudentFactory.createStudent(Helper.generateUUID(),"John Doe", 22);
        Student student2 = StudentFactory.createStudent(Helper.generateUUID(),"Sipo Lakazie", 21);
        course.addStudent(student);
        course.addStudent(student2);
        System.out.println(course.toString());
        System.out.println(course.isThereSpace());
        System.out.println(course.getStudents().size());
        System.out.println(course.getAvailableSpace());


        System.out.println(course.toString());
        System.out.println(course2.toString());
        System.out.println(course3.toString());
        System.out.println(course4.toString());
        System.out.println(student.toString().toLowerCase());
        System.out.println(course5.toString().toUpperCase());


        System.out.println("This is the stuff we looking at for now .......");
//
//        Lecturer lecturer = new Lecturer.Builder()
//                .setId(Helper.generateUUID())
//                .setName("Mr.Peter")
//                .setLastName("Buckingham")
//                .setQualification("Adv DIP")
//                .build();

//        System.out.println(lecturer.toString());
//
//        System.out.println(lecturer.toString());
        Lecturer lecturer = new LecturerFactory().createLecturer(Helper.generateAppendedUUID("Lecturer") ,"Mr.Mike", "Buckingham", "Adv DIP");
        Student student1 = new StudentFactory().createStudent(Helper.generateAppendedUUID("Student"), "John", 22);

        System.out.println(lecturer.toString());
        System.out.println(student1.toString());

        //max int  = 30 percoruse
        //if studnts > 30 return execption
        //else
        // static Studntcount ++ for each new student

//        Cleaner cleaner = new Cleaner();
//        cleaner.setId(Helper.generateAppendedUUID("Cleaner"));
//        cleaner.setName("John");
//        cleaner.setSurname("Wick");
//        System.out.println(cleaner.getName());
//        System.out.println(cleaner.getSurname());



        /// factory pattern
        Cleaner cleaner = new CleanerFactory().createCleaner(Helper.generateAppendedUUID("Cleaner"), "John", "Wick");

        System.out.println(cleaner.toString());






    }

}


