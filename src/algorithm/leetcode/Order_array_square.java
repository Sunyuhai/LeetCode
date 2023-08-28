package algorithm.leetcode;

import java.util.Arrays;

/***
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */
public class Order_array_square {
    public static void main(String[] args) {
        int[] nums = {4,-1,0,3,10};
        int[] res = sortedSquares(nums);
        System.out.println(Arrays.toString(res));

    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int len = nums.length - 1;
        int left = 0;
        int rigth = len;
        while (left <= rigth){
            int left_square = Math.abs(nums[left] * nums[left]);
            int rigth_square = Math.abs(nums[rigth] * nums[rigth]);
            if (left_square <= rigth_square){
                res[len] = rigth_square;
                rigth--;
                len--;
            }else {
                res[len] = left_square;
                left++;
                len--;
            }
        }
        return res;
    }
}
