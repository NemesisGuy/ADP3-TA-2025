package za.ac.cput.factory;

import za.ac.cput.domian.Lecturer;


//interfaces set the rules for the factory class
//has a public static method that returns a new instance of the class from the inner static class Builder
public class LecturerFactory {
    public static Lecturer createLecturer(String lecturerId, String lecturerName, String lastName,String email, String qualification) {
        return new Lecturer.Builder()
                .setId(lecturerId)
                .setName(lecturerName)
                .setLastName(lastName)
                .setEmail(email)
                .setQualification(qualification)
                .build();

    }

}
