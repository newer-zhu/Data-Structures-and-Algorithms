package leetcode_notes.medium;

import java.util.HashSet;


/**
 * 主要找到规律：若右指针的下一个字母重复，则记录此时的长度并左指针后移，此时左指针到右指针的字母必定不重复，所以右指针直接向右移动
 */
public class title3_AAA {
    public int lengthOfLongestSubstring(String s) {
        //结果
        int ans = 0;
        //左右指针
        int l = 0, r = -1;
        //去重判断
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (i != 0){
                //指针左移
                set.remove(s.charAt(l++));
            }
            while (r + 1 < s.length() && !set.contains(s.charAt(r+1))){
                set.add(s.charAt(r + 1));
                r++;
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
