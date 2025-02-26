package za.ac.cput;


import za.ac.cput.domian.Course;
import za.ac.cput.domian.Student;
import za.ac.cput.factory.CoursesFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.util.Helper;
import za.ac.cput.util.IDGenerator;

import java.rmi.server.UID;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Course course = CoursesFactory.createCourse(1, "Project 3", 20);
        Course course2 = CoursesFactory.createCourse(2, "ADP 3", 30);
        Course course3 = CoursesFactory.createCourse(IDGenerator.generateIntId(), "PROJ MAN 3", 40);
        Course course4 = CoursesFactory.createCourse(IDGenerator.generateIntId(), " ADT 3 ", 40);
        Course course5 = CoursesFactory.createCourse(Helper.generateIntId(), Helper.generateUUIdCozImCold(), 40);


        Student student = StudentFactory.createStudent(Helper.generateUUIdCozImCold(),"John", 22);
//Course course6 = new Course(builder);

//Srting ID UUID;
//Int id;
        System.out.println(course.toString());
        System.out.println(course2.toString());
        System.out.println(course3.toString());
        System.out.println(course4.toString());
        System.out.println(student.toString());
        System.out.println(course5.toString());

//        System.out.println(new Random().nextInt(Integer.MAX_VALUE));
//        System.out.println(UUID.randomUUID().toString());


//        System.out.println(course.toString());
        //   System.out.println(course.toString());
    }

}


