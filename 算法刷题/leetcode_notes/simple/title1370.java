package leetcode_notes.simple;

import java.util.*;

public class title1370 {
    //1370. 注意计数片段的代码
    public String sortString(String s) {
        int[] ints = new int[26];
        for (int i=0; i < s.length(); i++){
            ints[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()){
            for (int j=0; j < 26; j++){
                if (ints[j] > 0){
                    sb.append((char) 'a'+j);
                    ints[j]--;
                }
            }
            for (int k=25; k >= 0; k--){
                if (ints[k] > 0){
                    sb.append((char) 'a'+k);
                    ints[k]--;
                }
            }
        }
        return sb.toString();
    }
}
