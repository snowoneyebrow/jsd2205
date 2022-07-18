package leetcode;

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                int temp = 0;
                for (int k = j; k < j+i; k++) {
                    temp += nums[k];
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        /*
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(new Solution35().searchInsert(nums, target));
         */
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (target <= nums[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}

class Solution27 {
    /*
    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    System.out.println(new Solution27().removeElement(nums, val));
    System.out.println(Arrays.toString(nums));
     */
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        for (int i = 0; i < k; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < k; j++) {
                    nums[j - 1] = nums[j];
                }
                k--;
                i--;
            }
        }
        return k;
    }
}

class Solution26 {
    /*
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println(new Solution26().removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
     */
    public int removeDuplicates(int[] nums) {
        int k = nums.length;
        for (int i = 0; i < k - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < k; j++) {
                    nums[j - 1] = nums[j];
                }
                k--;
                i--;
            }
        }
        return k;
    }
}

class Solution1 {
    /*
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(new Solution1().twoSum(nums, target)));
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        here:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break here;
                }
            }
        }
        return result;
    }
}
