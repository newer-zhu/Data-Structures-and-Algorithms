package leetcode_notes.simple;

public class title334_A {
    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }
    public static void reverseString(char[] s) {
        char j;
        int l = s.length;
        for (int i=0; i < l/2; i++){
            j = s[i];
            s[i]  = s[l - i];
            s[l - i] = j;
        }
    }
}
