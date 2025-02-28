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


public class Main {
    public static void main(String[] args) {

        Course course = CoursesFactory.createCourse(1, "Project 3", 20, 20);
        Course course2 = CoursesFactory.createCourse(2, "ADP 3", 30, 30);
        Course course3 = CoursesFactory.createCourse(Helper.IDGenerator.generateIntID(), "PROJ MAN 3", 40, 30);
        Course course4 = CoursesFactory.createCourse(Helper.IDGenerator.generateIntID(), "ADT 3 ", 40, 30);
        Course course5 = CoursesFactory.createCourse(Helper.IDGenerator.generateIntID(), "Prof Dev 3" , 40, 30);

        Student student = StudentFactory.createStudent(Helper.IDGenerator.generateUUID(),"John Doe", 22);
        Student student2 = StudentFactory.createStudent(Helper.IDGenerator.generateUUID(),"Sipo Lakazie", 21);
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

        Lecturer lecturer = LecturerFactory.createLecturer(Helper.IDGenerator.generateAppendedUUID("Lecturer") ,"Mike", "Jones", "example@gmail.com","Adv DIP");
        Student student1 = StudentFactory.createStudent(Helper.IDGenerator.generateAppendedUUID( "Student"), "John Deer", 22);

        System.out.println(lecturer.toString());
        System.out.println(student1.toString());

        /// factory pattern
        Cleaner cleaner = CleanerFactory.createCleaner(Helper.IDGenerator.generateAppendedUUID("Cleaner"), "John", "Wick");

        System.out.println(cleaner.toString());


    }

}


