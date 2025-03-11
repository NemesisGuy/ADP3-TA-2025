package za.ac.cput.factory;

import za.ac.cput.domian.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {

    public static Student createStudent(String id , String name, int age) {

        // validation here
       return new Student.Builder()
                .setId(id)
                .setAge(age)
                .setName(name)
                .build();
    }

}
