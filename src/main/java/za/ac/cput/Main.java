package za.ac.cput;

import za.ac.cput.domian.Student;

public class Main {
    public static void main(String[] args) {

        Student student2 = new Student.Builder()
                .setAge(20)
                .setName("Jane Doe")
                .build();

        Student student3 = new Student.Builder()
                .setAge(22)
                .setName("Foo Bar")
                .build();

        System.out.println(student2.toString());
        System.out.println(student3.toString());







    }
}


