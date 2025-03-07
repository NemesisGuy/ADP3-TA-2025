package za.ac.cput;


import za.ac.cput.domian.Cleaner;
import za.ac.cput.domian.Course;
import za.ac.cput.domian.Lecturer;
import za.ac.cput.domian.Student;
import za.ac.cput.factory.CleanerFactory;
import za.ac.cput.factory.CoursesFactory;
import za.ac.cput.factory.LecturerFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;
import za.ac.cput.util.Helper;


public class Main {
    public static void main(String[] args) {
        //we want  the sutdent repo to be created

        StudentRepository studentRepository = new StudentRepository();

        //we want to create a students via the factory
        Student student = StudentFactory.createStudent("1", "Kamva krishna", 21);
        Student student2 = StudentFactory.createStudent("2", "Mike Jones", 21);

        //We want to add the students to the repository
        studentRepository.create(student);
        studentRepository.create(student2);

        System.out.println(studentRepository.readById("1"));

        //we want see what is in the repository at this point
        System.out.println(studentRepository.getAll());

        //we want to remove a student from the repository
        System.out.println( studentRepository.delete("5"));
        System.out.println(studentRepository.getAll()); //after deleting the student with the id on 1 for example
        System.out.println(Helper.IDGenerator.generateUUID());

    }

}


