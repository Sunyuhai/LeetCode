package algorithm.thirdLevel.siver;

import algorithm.thirdLevel.bronze.TraversalArray;

/**
 * 题目：按奇偶排序数组
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,4};
        TraversalArray.arrayprint(sortArrayByParity(arr));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] % 2 == 0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
        return nums;
    }
}
