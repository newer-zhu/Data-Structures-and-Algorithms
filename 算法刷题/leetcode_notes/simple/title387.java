package leetcode_notes.simple;

import java.util.*;

public class title387 {
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


}
