package validpalindrome;

/*
Problem: #125 Valid Palindrome

Description:
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

Solution's algorithm analysis:
Time complexity: O(n)
Space complexity: O(1)
*/

public class ValidPalindrome {
    public static void main(String[] args) {
        // String to validate
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is " + "[" + s + "] " + " a valid palindrome? " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        // Initialize two pointers: one at the start and one at the end of the string
        int left = 0;
        int right = s.length() - 1;

        // Loop until the two pointers meet
        while (left < right) {

            // Move the left pointer forward if the current character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move the right pointer backward if the current character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters at both pointers (ignoring case)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // If they don't match, it's not a palindrome
                return false;
            }

            // Move both pointers closer to the center
            left++;
            right--;

        }
        // If all characters matched, the string is a valid palindrome
        return true;
    }
}
