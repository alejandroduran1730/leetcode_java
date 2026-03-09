package reversestring;

import java.util.Arrays;

/*
Problem: #344 Reverse String

Description:
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.

Solution's algorithm analysis:
Time complexity: O(n)
Space complexity: O(1)
 */
public class ReverseString {
    public static void main(String[] args) {
        // Array of characters to reverse
        char[] characters = { 'h', 'e', 'l', 'l','o'};

        System.out.println("Original array: " + Arrays.toString(characters));
        System.out.println("Reversed array: " + Arrays.toString(reverseString(characters)));
    }

    public static char[] reverseString(char[] characters) {

        // Initialize two pointers: one at the start and one at the end of the string
        int left = 0;
        int right = characters.length - 1;

        // Loop until the two pointers meet
        while (left < right) {

            // Store the left value temporarily to avoid losing it
            char temp = characters[left];

            // Assign the right value to the left position
            characters[left] = characters[right];

            // Place the original left value into the right position
            characters[right] = temp;

            // Move left pointer forward
            left++;

            // Move right pointer backward
            right--;
        }
        return characters;
    }
}
