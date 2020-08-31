package leetcode_notes.simple;

public class title680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("deeee"));
    }
    public static boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int j = 0;
        int k = array.length - 1;
        boolean isChange = false;
        while (j != k){
            if (array[j] == array[k]){
                j++;
                k--;
            }else if (array[j] != array[k] && !isChange){
                j++;
                isChange = true;
            }else
                return false;
        }
        return true;
    }
}
