package algorithm.leetcode;

/***
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 */
public class Compare_backspace_string {
    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        return remove_backspace(s).equals(remove_backspace(t));
    }

    public static String remove_backspace(String str){
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#'){
                res.append(str.charAt(i));
            }else {
                if (res.length() >= 1){
                    res.deleteCharAt(res.length() - 1);
                }
            }
        }
        return res.toString();
    }
}
