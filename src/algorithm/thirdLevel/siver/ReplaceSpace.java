package algorithm.thirdLevel.siver;

/**
 * 题目：替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
