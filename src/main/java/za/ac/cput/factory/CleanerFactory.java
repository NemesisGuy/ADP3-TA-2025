package za.ac.cput.factory;

import za.ac.cput.domian.Cleaner;
import za.ac.cput.util.Helper;

public class CleanerFactory {
    public static Cleaner createCleaner(String id, String name, String surname) {
        Cleaner cleaner = new Cleaner.Builder()
                .setId(Helper.IDGenerator.generateAppendedUUID(id))
                .setName(name)
                .setSurname(surname)
                .build();
        return cleaner;


    }

}
