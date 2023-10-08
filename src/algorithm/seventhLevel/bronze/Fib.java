package algorithm.seventhLevel.bronze;

/**
 * 题目：斐波纳契数列
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib_1(5));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int fib_1(int n) {
        int fib0 = 0;
        int fib1 = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (fib0 + fib1) % 1000000007;
            fib0 = fib1;
            fib1 = sum;
        }
        return fib0;
    }


    /**
     * 递归
     * @param n
     * @return
     */
    public static int fib_2(int n) {
        int dfs = dfs(n);
        return dfs;
    }

    public static int dfs(int n){
        if(n < 2) return n;
        return (dfs(n - 1) + dfs(n - 2)) % 1000000007;
    }
}
