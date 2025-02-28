package za.ac.cput.factory;

import za.ac.cput.domian.Course;
import za.ac.cput.domian.Student;

import java.util.ArrayList;

public class CoursesFactory implements IFactory {

    public static Course createCourse (int id, String name, int credits, int maxStudents) {
        return new Course.Builder()
                .setId(id)
                .setName(name)
                .setCredits(credits)
                .setMaxStudents(maxStudents)
                .build();
    }


    @Override
    public <T> T Create() {
        return null;
    }
}
