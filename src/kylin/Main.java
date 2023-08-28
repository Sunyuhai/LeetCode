package kylin;


/**
 https://blog.csdn.net/afei__/article/details/83214042?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169207341916800227443615%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=169207341916800227443615&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-83214042-null-null.142^v92^chatgptT3_1&utm_term=%E6%9C%80%E9%95%BF%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92&spm=1018.2226.3001.4187
 */
public class Main {

    public static void main(String[] args) {
        String s = "cabbeaf";
        System.out.println(getLPS(s));
    }

    public static int getLPS(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 第一维参数表示起始位置的坐标，第二维参数表示长度，使用 0 表示长度 1
        int[][] lps = new int[length][length];
        for (int i = 0; i < length; i++) {
            lps[i][i] = 1; // 单个字符的最长回文子序列长度为1，特殊对待一下
        }
        // (i + 1) 表示当前循环的子字符串长度
        for (int i = 1; i < length; i++) {
            // j 表示当前循环的字符串起始坐标
            for (int j = 0; i + j < length; j++) {
                // 即当前循环的子字符串坐标为 [j, i + j]
                // 所以第一个字符是 chars[j]，最后一个字符就是 chars[i + j]
                if (chars[j] == chars[i + j]) {
                    lps[j][i + j] = lps[j + 1][i + j - 1] + 2;
                } else {
                    lps[j][i + j] = Math.max(lps[j][i + j - 1], lps[j + 1][i + j]);
                }
            }
        }
        // 最大值一定在以0为起始点，长度为 length - 1 的位置
        return lps[0][length - 1];
    }

}
