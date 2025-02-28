package za.ac.cput.util;

import java.util.Random;
import java.util.UUID;

public class Helper {
    public static String generateUUID() {

        return UUID.randomUUID().toString();
    }

    public static String generateAppendedUUID(String role)
    {
        return role +"-"+ UUID.randomUUID().toString();
    }

    public static int generateIntID() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }

    public static class IDGeneretaor
    {
        public static String generateUUID() {
            return UUID.randomUUID().toString();
        }
        public static String generateAppendedUUID(String role)
        {
            return role +"-"+ UUID.randomUUID().toString();
        }
        public static int generateIntID()
        {
            return new Random().nextInt(Integer.MAX_VALUE);
        }
    }
}
