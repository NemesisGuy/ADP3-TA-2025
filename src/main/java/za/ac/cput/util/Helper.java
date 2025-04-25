package za.ac.cput.util;

import javax.mail.internet.InternetAddress;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class Helper {

    public static class IDGenerator {
        public static String generateUUID() {
            return UUID.randomUUID().toString();
        }

        public static String generateAppendedUUID(String role) {
            return role + "-" + UUID.randomUUID();
        }

        public static int generateIntID() {
            return new Random().nextInt(Integer.MAX_VALUE);
        }
    }

    public static class Validate {
        public static boolean age(LocalDate age) {
            // check if age is greater than 18 years old and less than 150 years old
            return Dates.getAge(age) >= 18 && Dates.getAge(age) < 150;

        }

        public static boolean isString(String value) {
            return value != null && !value.isEmpty() && !value.trim().isEmpty();
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

    public static class Dates {
        public static boolean isDate(LocalDate date) {
            return date != null;
        }

        //today
        public static LocalDate today() {
            return LocalDate.now();
        }

        //generateDateOfBirthForAdult for testing purposes, random age over 21
        public static LocalDate generateDateOfBirthForAdult() {
            return today().minusYears(new Random().nextInt(25) + 18);
        }


        //getAge
        public static int getAge(LocalDate date) {
            return today().getYear() - date.getYear();
        }

    }

    public static class Names {
        public static boolean isName(String name) {
            return name != null && !name.isEmpty() && !name.trim().isEmpty();
        }

        //generateName
        public static String generateName() {
            //generate random real name
            String[] names = {"John", "Jane", "Doe", "Smith", "Micheal", "Sara", "David", "Mary", "James", "Patricia"};
            return names[new Random().nextInt(names.length)];
        }

        //generateSurname
        public static String generateSurname() {
            //generate random real surname
            String[] surnames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
            return surnames[new Random().nextInt(surnames.length)];
        }


    }

}

// hot to know is entity
// life-time
// unique
// thing noun
