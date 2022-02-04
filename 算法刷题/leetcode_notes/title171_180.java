package leetcode_notes;

public class title171_180 {
    //26进制转换为10进制
    public int titleToNumber(String s) {
        int res = 0;
        for (char c: s.toCharArray()){
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}
