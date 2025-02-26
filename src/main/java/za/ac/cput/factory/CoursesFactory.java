package za.ac.cput.factory;

import za.ac.cput.domian.Course;

public class CoursesFactory implements IFactory {

    public static Course createCourse (int id, String name, int credits){
        return new Course.Builder()
                .setId(id)
                .setName(name)
                .setCredits(credits)
                .build();
    }


    @Override
    public <T> T Create() {
        return null;
    }
}
