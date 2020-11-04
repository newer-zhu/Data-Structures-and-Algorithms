package leetcode_notes.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class title804 {
    public static void main(String[] args) {
        uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
    }
    public static int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> map = new HashMap<>();
        String[] ss = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (char c = 97; c <= 122 ; c++)
            map.put(c,ss[c-97]);
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String s : words){
            for (int i = 0; i < s.length(); i++){
                sb.append(map.get(s.charAt(i)));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
