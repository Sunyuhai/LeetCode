package algorithm.leetcode;


/***
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class Binary_search {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int res = binary_search_2(nums,target);
        System.out.println(res);
    }

    /**
     * 定义target在[left, right]区间,while (left <= right) 要使用 <=
     * @param nums
     * @param target
     * @return
     */
    private static int binary_search_1(int[] nums, int target){
        int left = 0;
        int rigth = nums.length - 1;
        while (left <= rigth){
            int mid = left + (rigth - left) / 2;
            if (nums[mid] > target){
                rigth = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 定义target在[left, right）区间,while (left < right) 要使用 <
     * @param nums
     * @param target
     * @return
     */
    private static int binary_search_2(int[] nums, int target){
        int left = 0;
        int rigth = nums.length - 1;
        while (left < rigth){
            int mid = left + (rigth - left) / 2;
            if (nums[mid] > target){
                rigth = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
