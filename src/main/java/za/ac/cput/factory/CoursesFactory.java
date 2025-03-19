package za.ac.cput.factory;

import za.ac.cput.domian.Course;
import za.ac.cput.domian.Student;
import za.ac.cput.domian.Subject;

import java.util.ArrayList;

public class CoursesFactory {

    public static Course create(int id, String name, int credits, int maxStudents, ArrayList<Student> students, ArrayList<Subject> subjects) {
        return new Course.Builder()
                .setId(id)
                .setName(name)
                .setCredits(credits)
                .setMaxStudents(maxStudents)
                .setStudents(students)
                .setSubjects(subjects)
                .build();
    }


}
