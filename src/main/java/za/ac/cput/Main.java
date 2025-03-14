package za.ac.cput;

import za.ac.cput.domian.Janitor;
import za.ac.cput.domian.Student;
import za.ac.cput.factory.JanitorFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.JanitorRepository;
import za.ac.cput.repository.StudentRepository;
import za.ac.cput.util.Helper;


public class Main {
    public static void main(String[] args) {
        //we want  the student repo to be created

        //StudentRepository studentRepository = new StudentRepository();
        StudentRepository studentRepository = StudentRepository.getRepository();

        //we want to create a students via the factory
        Student student = StudentFactory.create("1", "Kamva", "krishna", 21);
        Student student2 = StudentFactory.create("2", "Mike" ,"Jones", 21);

        //We want to add the students to the repository
        studentRepository.create(student); //ome element in the arraylist
        studentRepository.create(student2);//two elements in the arraylist

        System.out.println(studentRepository.read("1"));

        //we want see what is in the repository at this point
        System.out.println(studentRepository.getAll());

        //we want to remove a student from the repository
        System.out.println( studentRepository.delete("1"));
        System.out.println(studentRepository.getAll()); //after deleting the student with the id on 1 for example
        System.out.println(Helper.IDGenerator.generateUUID());


        System.out.println("======================= Cleaner Stuff ==============================");

        JanitorRepository janitorRepository = JanitorRepository.getRepository();
        Janitor janitor = JanitorFactory.create("1", "Jack", "Smith");

        Janitor janitor2 = JanitorFactory.create("2", "Bilal"," Khan");

        janitorRepository.create(janitor);
        janitorRepository.create(janitor2);
        System.out.println(janitorRepository.read("1"));
        System.out.println(janitorRepository.getAll());
        System.out.println(janitorRepository.delete("1"));
        System.out.println(janitorRepository.getAll());


    }

}


