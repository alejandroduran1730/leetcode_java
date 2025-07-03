package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: #1 Two Sum
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Solution's time complexity and space complexity:
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0]; // If no solution is found
    }

    public static void main(String[] args) {
        TwoSum main = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(main.twoSum(nums, target)));
    }
}