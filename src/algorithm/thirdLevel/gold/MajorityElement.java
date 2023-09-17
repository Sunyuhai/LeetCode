package algorithm.thirdLevel.gold;

import java.util.HashMap;

/**
 * 题目：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0) + 1);
            if (hashMap.get(nums[i]) > nums.length / 2){
                return nums[i];
            }
        }
        return 0;
    }

}
