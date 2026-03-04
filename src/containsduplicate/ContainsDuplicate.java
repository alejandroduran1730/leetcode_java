package containsduplicate;

import java.util.HashSet;
import java.util.Set;

/*
Problem: #217 Contains Duplicate

Description: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println("Does nums contain duplicates? " + containsDuplicate(nums));
    }
}
