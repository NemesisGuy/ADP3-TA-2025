package za.ac.cput.factory;

import za.ac.cput.domian.Student;

public class StudentFactory {

    public static Student create(String id , String firstName, String lastName, int age) {

        // validation here
       return new Student.Builder()
                .setId(id)
                .setAge(age)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }

}
