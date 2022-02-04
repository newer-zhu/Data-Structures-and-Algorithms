package leetcode_notes.simple;

import java.util.*;

public class title381_390 {
    //title387
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = s.length();
        for (int i=0; i<l; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int j=0; j<l; j++){
            if (map.get(s.charAt(j)) == 1){
                return j;
            }
        }
        return -1;
    }

    //title389
    public char findTheDifference(String s, String t) {
        int[] c = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (char ch : ss){
            c[ch - 'a']++;
        }
        for (char ch : tt){
            c[ch - 'a']--;
            if (c[ch - 'a'] < 0)
                return ch;
        }
        return 'a';
    }


}
