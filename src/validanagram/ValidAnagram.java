package validanagram;
/*
Problem: #242 Valid Anagram

Description:
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.

Solution's time complexity and space complexity:
Time Complexity: O(n log n)
Space Complexity: O(n)
 */

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println("Is " + s + " anagram of " + t + " ? " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        // If both s and t length don't match, it is not an anagram
        if (s.length() != t.length()) {
            return false;
        }

        // Convert both strings to character arrays
        char[] a = s.toCharArray();
        char[] b = s.toCharArray();

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Return the compared result, if they're identical, the strings are anagrams
        return Arrays.equals(a, b);
    }
}
