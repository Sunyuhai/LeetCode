package kylin;


import java.util.*;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        String ss = "abba";

        System.out.printf("ss", lengthOfLongestSubstring(ss));

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        // abcabcbb
        int i = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j),j);
            maxLen = Math.max(maxLen,j - i + 1);
        }
        return maxLen;
    }
}
