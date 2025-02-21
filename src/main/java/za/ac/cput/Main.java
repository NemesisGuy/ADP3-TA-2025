package za.ac.cput;

import za.ac.cput.domian.Student;
import za.ac.cput.factory.StudentFactory;

public class Main {
    public static void main(String[] args) {

        Student student = StudentFactory.createStudent("jane doe" , 20);
        Student student2 = StudentFactory.createStudent("jhon wick" , 21);

        System.out.println(student.toString());
        System.out.println(student2.toString()) ;


    }
}


