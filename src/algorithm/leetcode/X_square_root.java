package algorithm.leetcode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 输入：x = 4
 * 输出：2
 */
public class X_square_root {
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }

    public static int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if ((long)middle * middle <= x) {
                ans = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ans;
    }
}
