package za.ac.cput.factory;

import za.ac.cput.domian.Student;

public class StudentFactory {

    public static Student createStudent(String id , String name, int age) {
        // creation logic would go here , age validate
        return new Student.Builder()
                .setId(id)
                .setAge(age)
                .setName(name)
                .build();
    }

}
