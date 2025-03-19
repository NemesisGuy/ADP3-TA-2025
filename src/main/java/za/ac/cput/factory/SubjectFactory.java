package za.ac.cput.factory;

import za.ac.cput.domian.Lecturer;
import za.ac.cput.domian.Subject;

import java.util.List;


//
//private String id, name;
//private int credits;
//private List<Lecturer> lecturers;

public class SubjectFactory {
    public static Subject create(String id, String name, int credits, List<Lecturer> lecturers) {
        return new Subject.Builder()
                .setId(id)
                .setName(name)
                .setCredits(credits)
                .setLecturers(lecturers)
                .build();
    }
}
