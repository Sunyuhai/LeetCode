package algorithm.leetcode;

/***
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元
 * 素。
 */
public class Remove_element {
    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(removeElement(nums, 3));
    }
    // 快指针去循环，只要快指针没有循环到目标值，就更换快慢指针数据，并且慢指针++，如果循环到目标值，慢指针不动，继续向下循环，直至结束。
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast <= nums.length - 1; fast++) {
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
