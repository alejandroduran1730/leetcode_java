package validparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem: #20 Valid Parentheses

Description: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

Solution's algorithm analysis:
Time Complexity: O(n)
Space Complexity: O(n)
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String string = "([])"; // String to be validated

        System.out.println("Is " + string + " valid? " + isValid(string));
    }

    public static boolean isValid(String s) {
        // If the number of characters is odd, it means is invalid
        if (s.length() % 2 != 0) {
            return false;
        }

        // Use Deque (implemented by ArrayDeque) instead of Stack to have the best performance
        // Stack is legacy and synchronized (slower)
        //ArrayDeque is faster and recommended for stack behavior
        Deque<Character> deque = new ArrayDeque<>();

        // Traverse each character
        for (char character : s.toCharArray()) {
            // If it's an opening bracket, push the expected closing bracket
            if (character == '(') {
                deque.push(')');
            } else if (character == '{') {
                deque.push('}');
            } else if (character == '[') {
                deque.push(']');
            } else {
                // If the deque is empty or current character doesn't match the top character
                if (deque.isEmpty() || deque.pop() != character) {
                    return false;
                }
            }
        }
        // Valid only if no unmatched brackets remain
        return deque.isEmpty();
    }
}
