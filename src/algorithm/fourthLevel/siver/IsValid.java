package algorithm.fourthLevel.siver;


import java.util.HashMap;
import java.util.Stack;

/**
 * 题目：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 输入：s = "()[]{}"
 * 输出：true
 */
public class IsValid {
    public static void main(String[] args) {
        String str = "()]{}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        if (s.length() <= 1) return false;
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)){
                stack.push(c);
            }else {
                if (!stack.empty()){
                    Character pop = stack.pop();
                    Character character = hashMap.get(pop);
                    if (!character.equals(c)){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
