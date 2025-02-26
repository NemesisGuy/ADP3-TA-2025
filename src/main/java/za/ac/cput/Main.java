package za.ac.cput;


import za.ac.cput.domian.Course;
import za.ac.cput.domian.Student;
import za.ac.cput.factory.CoursesFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.util.Helper;
import za.ac.cput.util.IDGenerator;



public class Main {
    public static void main(String[] args) {

        Course course = CoursesFactory.createCourse(1, "Project 3", 20);
        Course course2 = CoursesFactory.createCourse(2, "ADP 3", 30);
        Course course3 = CoursesFactory.createCourse(IDGenerator.generateIntId(), "PROJ MAN 3", 40);
        Course course4 = CoursesFactory.createCourse(IDGenerator.generateIntId(), " ADT 3 ", 40);
        Course course5 = CoursesFactory.createCourse(Helper.generateIntId(), "Prof Dev 3" , 40);

        Student student = StudentFactory.createStudent(Helper.generateUUIdCozImCold(),"John", 22);


        System.out.println(course.toString());
        System.out.println(course2.toString());
        System.out.println(course3.toString());
        System.out.println(course4.toString());
        System.out.println(student.toString().toLowerCase());
        System.out.println(course5.toString().toUpperCase());

    }

}


