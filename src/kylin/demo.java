package kylin;


import java.util.*;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        String s = "pwwkew";
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left++;
                map.remove(s.charAt(i));
            }
            right++;
            map.put(s.charAt(i), i);
            max = Math.max(max, right - left);
        }
        System.out.println(max);
    }


    /**
     * 修改demo
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        // abcabcbb
        int i = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
//                i = Math.max(i,map.get(s.charAt(j)) + 1);
                i = map.get(s.charAt(j)) + 1;
            }
            map.put(s.charAt(j),j);
            maxLen = Math.max(maxLen,j - i + 1);
        }
        return maxLen;
    }
}
