import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String t = "ABCDAB";
        int i = KmpSearch(s, t, kmpNext(t));
        System.out.println(Arrays.toString(kmpNext(t)));
        System.out.println(i);
    }

    /**
     * 数组下标代表了字串的下标，对应的值便是kmp匹配值
     * @param dest 字串
     * @return 获取一个子串的部分匹配值表
     */
    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;//只有一个字母匹配值肯定为0
        for (int i = 1,j = 0; i < dest.length(); i++){
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int KmpSearch(String source,String target,int[] next){
        for (int i = 0,j = 0; i < source.length(); i++){
            while (j > 0 && source.charAt(i) != target.charAt(j))
                j = next[j-1];
            if (source.charAt(i) == target.charAt(j))
                j++;
            //找到了
            if (j == target.length())
                return i - j + 1;
        }
        return -1;
    }
}
