package 剑指Offer;

import java.util.Arrays;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        char[] arr = s.toCharArray();
        //窗口右下标
        int end = 0;
        //窗口坐下标
        int start = 0;
        //此字符上次出现的index
        int[] mp = new int[128];
        Arrays.fill(mp, -1);
        for (; end < arr.length; end++) {
            if (mp[arr[end]] < start){
                len = Math.max(len, end - start + 1);
            }else {
                start = mp[arr[end]] + 1;
            }
            mp[arr[end]] = end;
        }
        return len;
    }
}
