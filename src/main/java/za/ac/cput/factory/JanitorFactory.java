package za.ac.cput.factory;

import za.ac.cput.domain.Janitor;

public class JanitorFactory {
    public static Janitor create(String id, String firstName, String lastName, String shift) {
        //valid if true do x else do y

        Janitor janitor = new Janitor.Builder()
                // .setId(Helper.IDGenerator.generateAppendedUUID(id))
                .setId((id))
                .setFirstName(firstName)
                .setLastName(lastName)
                .setShift(shift)
                .build();
        return janitor;


    }

}
