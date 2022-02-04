package leetcode_notes.位运算;

public class example {
    /**
     * 用32位整数表示一个单词出现的字符，a是最低位
     * hash【i】表示第i个单词出现过的字母
     */
    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (Character c : words[i].toCharArray()){
                hash[i] |= 1 << (c - 'a');
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for(int j = i+1; j < words.length; ++j) {
                if((hash[i] & hash[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }

    /**
     * title461
     * 运用异或运算，同时计算一串二进制里1的个数可以用移位运算
     */
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
