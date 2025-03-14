package za.ac.cput.util;

import  javax.mail.internet.InternetAddress;

import java.util.Random;
import java.util.UUID;

public class Helper {

    public static class IDGenerator
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

    public static class Validate
    {
        public static boolean age(int age)
        {
            return age > 16 && age < 150;
        }
        public static boolean isString(String value)
        {
            return value != null && !value.isEmpty()&& !value.trim().isEmpty();
        }
        public static boolean email(String email) {
            try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
                System.out.println("Email is valid");
                return true;
            } catch (Exception e) {
                System.out.println("Email is not valid");
                return false;
            }
        }
        public static boolean isNotNull(Object obj) {
            return obj != null;
        }

        public static boolean isNull(Object obj) {
            return obj == null;
        }
    }

}

// hot to know is entity
// life-time
// unique
// thing noun
