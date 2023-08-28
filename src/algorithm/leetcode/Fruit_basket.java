package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;


/***
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一
 * 棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 * 输入：fruits = [0,1,2,2]，[1,2,3,2,2]
 * 输出：3，4
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 */
public class Fruit_basket {
    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }

    public static int totalFruit(int[] fruits) {
        int slow = 0;
        int result = Integer.MIN_VALUE;
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for (int fast = 0; fast < fruits.length; fast++) {
            hashMap.put(fruits[fast],hashMap.getOrDefault(fruits[fast],0) + 1);
            while (hashMap.size() > 2){
                hashMap.put(fruits[slow],hashMap.get(fruits[slow]) - 1);
                if (hashMap.get(fruits[slow]) == 0){
                    hashMap.remove(fruits[slow]);
                }
                slow++;
            }
            result = Math.max(result,fast - slow + 1);
        }
        return result;
    }
}
