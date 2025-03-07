package za.ac.cput.factory;

import za.ac.cput.domian.Course;
import za.ac.cput.domian.Student;

import java.util.ArrayList;

public class CoursesFactory{

    public static Course createCourse (int id, String name, int credits, int maxStudents) {
        return new Course.Builder()
                .setId(id)
                .setName(name)
                .setCredits(credits)
                .setMaxStudents(maxStudents)
                .build();
    }



}
