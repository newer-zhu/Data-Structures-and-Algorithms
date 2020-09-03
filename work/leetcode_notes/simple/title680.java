package leetcode_notes.simple;

import java.util.HashMap;

public class title680 {
    public static void main(String[] args) {
    }
    public boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int j = 0;
        int k = array.length - 1;
        while (j < k){
            if (s.charAt(j) != s.charAt(k)){
                return judge(s,j,k-1) || judge(s,j+1,k);
            }
            j++;
            k--;
        }
        return true;
    }

    public boolean judge(String s, int j, int k){
        while (j < k){
            if (s.charAt(j) != s.charAt(k))
                return false;
            j++;
            k--;
        }
        return true;
    }
}
