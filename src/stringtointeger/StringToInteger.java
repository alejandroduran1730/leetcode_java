package stringtointeger;

/*
Problem: #8 String to integer (atoi)
Description:
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

Example 1:
Input: s = "42"
Output: 42
Explanation:
The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^

Example 2:
Input: s = " -042"
Output: -42
Explanation:
Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^
Example 3:
Input: s = "1337c0d3"
Output: 1337
Explanation:
Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^

Example 4:
Input: s = "0-1"
Output: 0
Explanation:
Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^

Example 5:
Input: s = "words and 987"
Output: 0
Explanation:
Reading stops at the first non-digit character 'w'.

Constraints:
0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

Solution's algorithm analysis:
Time Complexity: O(n)
Space Complexity: O(1)
 */

public class StringToInteger {
    public static void main(String[] args) {
        String s = "-987 and words";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        // index used to traverse the string
        int index = 0;

        // size of string for boundary checking
        int size = s.length();

        // result will store the converted number
        int result = 0;

        // sign stores whether the number is positive or negative
        int sign = 1;

        // Step 1: Skip leading whitespaces
        while (index < size && s.charAt(index) == ' ') {
            index++; // Move to next character
        }

        // Step 2: Check sign
        if (index < size && s.charAt(index) == '+') {
            sign = 1; // 1 means the number is positive
            index++; // Move to next character
        } else if (index < size && s.charAt(index) == '-') {
            sign = -1; // -1 means the number is negative
            index++; // Move to next character
        }

        // Step 3: Convert digits to integer
        while (index < size && Character.isDigit(s.charAt(index))) {

            // Convert character to integer digit
            // Note: Characters in Java are stored using ASCII (or Unicode, which preserves ASCII values)
            // Character - ASCII Value
            // '0' - 48
            // ...
            // '9' - 57
            // '7' - '0' = 55 - 48 = 7
            // Note: Doing this provides the ASCII value: int digit = (int) s.charAt(index);

            int digit = s.charAt(index) - '0';

            // Step 4: Check for overflow before multiplying and adding

            // Ensure the number stays within the 32-bit signed integer range
            // Integer.MAX_VALUE = 2147483647
            // Integer.MIN_VALUE = -2147483648
            // To verify whether: result * 10 + digit <= Integer.MAX_VALUE
            // Rearranging the inequality: result * 10 <= Integer.MAX_VALUE - digit
            // Divide both sides by 10
            // result <= (Integer.MAX_VALUE - digit) / 10
            // So before updating result, check:
            // if (result > (Integer.MAX_VALUE - digit) / 10)
            // if true, adding the digit would cause overflow
            // to avoid overflow, return only MAX_VALUE or MIN_VALUE, depending on the sign

            if (result > (Integer.MAX_VALUE - digit) / 10) {

                // Return max or min based on sign
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else { // sign = -1
                    return Integer.MIN_VALUE;
                }
            }

            // Shift digits left and add the new digit
            // Multiply result by 10 and add digit
            result = result * 10 + digit;

            // Move to next character
            index++;
        }

        // Step 5: Apply sign and return result
        return result * sign;
    }
}
