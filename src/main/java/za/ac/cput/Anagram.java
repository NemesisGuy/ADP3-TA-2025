package za.ac.cput;

import java.util.Arrays;

/*iven an array of strings strs, group the anagrams together. You can return the answer in any order.



        Example 1:

        Input: strs = ["eat","tea","tan","ate","nat","bat"]

        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Explanation:

        There is no string in strs that can be rearranged to form "bat".
        The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
        The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
        Example 2:

        Input: strs = [""]

        Output: [[""]]

        Example 3:

        Input: strs = ["a"]

        Output: [["a"]]



        Constraints:

        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
        strs[i] consists of lowercase English letters.*/
public  class Anagram {
    public static void main(String[] args) {
        String[] words = {"listeN", "silent", "enlisT ", "inlets ", " google", " glooge"," tree"};
        String currentWord = "listen";
        //loop through then group matches as subarrays
        System.out.println("Anagrams of " + currentWord + ":");

        for (String word : words) {
            if (isAnagram(currentWord, word)) {
                System.out.println("is anagram : " + word);
            }else {
                System.err.println("not anagram : " + word);
            }
        }

    }



    public static boolean isAnagram(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.toLowerCase().strip();
        str2 = str2.toLowerCase().strip();

        // Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Sort the characters of both strings
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

}


