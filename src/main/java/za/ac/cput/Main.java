package za.ac.cput;


import za.ac.cput.domian.Course;
import za.ac.cput.factory.CoursesFactory;

public class Main {
    public static void main(String[] args) {

//        Student student = StudentFactory.createStudent("jane doe" , 20);
//        Student student2 = StudentFactory.createStudent("jhon wick" , 21);
//
//        System.out.println(student.toString());
////        System.out.println(student2.toString()) ;
//        Course course =  new Course(1, "adp", 50);

//        Course course2 =  new Course(2"adp", 100);

//        Course course =  new Course(1, "adp", 50);
//        Course courseB =  new Course( 30);
//        Course courseB =  new Course( 4, "adp4");

        Course course = CoursesFactory.createCourse(1, "adp2", 20);
        Course course2 = CoursesFactory.createCourse(2, "adp3", 30);
        System.out.println(course.toString());
        System.out.println(course2.toString());



        //   System.out.println(course.toString());
    }

}


