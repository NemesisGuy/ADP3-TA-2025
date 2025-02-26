package za.ac.cput.factory;

import za.ac.cput.domian.Course;

public class CoursesFactory {

    public static Course createCourse (int id, String name, int credits){
        return new Course.Builder()

                .setId(id)
                .setName(name)
                .setCredits(credits)
                .build();

    }



}
