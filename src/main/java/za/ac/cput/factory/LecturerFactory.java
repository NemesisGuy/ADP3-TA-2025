package za.ac.cput.factory;

import za.ac.cput.domian.Lecturer;
import za.ac.cput.util.Helper;

//inter that set rules for the factory class
//has a public static method that returns a new instance of the class
public class LecturerFactory {
    public static Lecturer createLecturer(String lecturerId, String lecturerName, String lastName, String qualification) {
        return new Lecturer.Builder()
                .setId(lecturerId)
                .setName(lecturerName)
                .setLastName(lastName)
                .setQualification(qualification)
                .build();

    }

}
