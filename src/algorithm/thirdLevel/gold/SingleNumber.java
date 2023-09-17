package algorithm.thirdLevel.gold;

/**
 * 题目：只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入：nums = [2,2,1]
 * 输出：1
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1};
        System.out.println(singleNumber(arr));
    }

    /**
     * 异或运算规则：
     *  0 ^ 0 = 0
     *  0 ^ a = a
     *  a ^ a = 0
     *  a ^ a ^ b = b
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num = num ^ i;
        }
        return num;
    }
}
