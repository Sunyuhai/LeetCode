package algorithm.leetcode;

import java.util.Arrays;

/***
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *  如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 *  输入：nums = [5,7,7,8,8,10], target = 8
 *  输出：[3,4]
 */
public class Seach_first_last_location {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 9;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }


    public static int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums,target);
        // start == nums.length,防止数组为空的时候，数据下标溢出
        if(start == nums.length || nums[start] != target) return new int[]{-1,-1};
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start,end};
    }

    /**
     * 返回 left,表示target第一次出现数组中的位置，返回 mid,表示target 出现的位置
     * @param nums
     * @param target
     * @return
     */
    private static int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

}
