package leetcode_notes.simple;

import java.util.*;

/**
 * 利用好hashset去重的特性
 */
public class title1207 {
    public static void main(String[] args) {
        boolean b = uniqueOccurrences(new int[]{1, 2, 12});
        System.out.println(b);
    }
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr){
            if (!map.keySet().contains(i))
                map.put(i,1);
            else {
                map.put(i,map.get(i)+1);
            }
        }
        return map.size() == new HashSet<Integer>(map.values()).size();
    }
}
