package leetcode_notes.simple;

public class tittle14_AA {
    public String longestCommonPrefix(String[] strs) {
        int l = strs.length;
        if(l == 0 )
            return "";
        //找到数组中长度最小的一个字符串，并标记该字符串
        int min = strs[0].length() , s = 0;
        for (int i = 1; i < l; i++){
            if (min > strs[i].length()){
                min = strs[i].length();
                s = i;
            }
        }
        int p = 0;//公共前缀指针
        for (int j = 0; j < min; j++, p++){
            //遍历数组核对前缀
            for (String ss : strs){
                //数组中有不匹配的
                if (ss.charAt(j) != strs[s].charAt(p)){
                    if (j == 0)//第一个字母就不匹配
                        return "";
                    return strs[s].substring(0,p);
                }
            }
        }
        return strs[s];
    }
}
