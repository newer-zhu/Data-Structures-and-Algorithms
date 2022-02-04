package leetcode_notes.simple;


import java.util.*;

/**
 * set的去重和统计只出现一次的单词是两码事！！！！！！！！！！！！！！！！！！！！！
 */
public class title884 {
    public static void main(String[] args) {
        uncommonFromSentences("this apple is sweet",
                "this apple is sour");
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String s = A + " " + B;
        String[] s1 = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : s1){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for (String k : map.keySet()){
            if (map.get(k) == 1)
                list.add(k);
        }

        return list.toArray(String[]::new);
    }
}
