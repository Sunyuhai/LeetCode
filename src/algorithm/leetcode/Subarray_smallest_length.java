package algorithm.leetcode;


/***
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 */
public class Subarray_smallest_length {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int solw = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target){
                result = Math.min(result,fast - solw + 1);
                sum -= nums[solw];
                solw++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
