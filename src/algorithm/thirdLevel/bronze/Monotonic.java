package algorithm.thirdLevel.bronze;

/**
 * 题目：单调序列
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> =
 * nums[j]，那么数组 nums 是单调递减的。
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 * 输入：nums = [1,2,2,3]
 * 输出：true
 */
public class Monotonic {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        System.out.println(isMonotonic(arr));
    }

    public static boolean isMonotonic(int[] nums) {
        return isSort(nums,true) || isSort(nums,false);
    }

    /**
     * 判断是不是单调序列
     * @param nums
     * @param flag true就是升序，false就是降序
     * @return
     */
    public static boolean isSort(int[] nums, Boolean flag) {
        if (flag){
            for (int i = 0; i < nums.length - 1; i++) {
                if(nums[i] > nums[i + 1]){
                    return false;
                }
            }
        }else {
            for (int i = 0; i < nums.length - 1; i++) {
                if(nums[i] < nums[i + 1]){
                    return false;
                }
            }
        }
        return true;
    }
}
