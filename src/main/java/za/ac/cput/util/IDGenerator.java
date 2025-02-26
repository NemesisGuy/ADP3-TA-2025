package za.ac.cput.util;

import java.util.Random;
import java.util.UUID;

public class IDGenerator {
    public static String generateUUId() {
        return UUID.randomUUID().toString();
    }

    public static int generateIntId() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
