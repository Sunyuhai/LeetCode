package algorithm.leetcode;


/***
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *  输入: nums = [1,3,5,6], target = 5
 *  输出: 2
 */
public class Search_insertion_location {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        int res = searchInsert(nums,target);
        System.out.println(res);
    }

    private static int searchInsert(int[] nums, int target) {
        int left = 0;
        int rigth = nums.length - 1;
        int mid = 0;
        while (left <= rigth){
            mid = left + (rigth - left) / 2;
            if(nums[mid] > target){
                rigth = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        if (nums[mid] > target){
            return mid;
        }else {
            return mid + 1;
        }
    }
}
