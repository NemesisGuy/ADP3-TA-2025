package za.ac.cput;

import java.util.ArrayList;

public class Palindrome {
    public static void main(String[] args) {
        ArrayList <String> words = new ArrayList<>();
        words.add("madam");
        words.add("racecar");
        words.add("hello");
        words.add("world");
        words.add("level");
        words.add("deified");
        words.add("civic");
        words.add("radar");
        words.add("rotor");
        words.add("noon");
        isPalindrome(words);
    }
    public static void isPalindrome(ArrayList<String> words) {
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                System.out.println(word + " is a palindrome");
            } else {
                System.err.println(word + " is not a palindrome");
            }
        }
    }

}
