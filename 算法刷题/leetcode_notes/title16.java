package leetcode_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class title16 {


    List<String> ans = new ArrayList<>();
    String num;
    int len;
    int target;
    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.len = num.length();
        this.target = target;
        backtrack(new StringBuilder(), 0, 0, 0);
        return ans;
    }

    public void backtrack(StringBuilder sb, int index, long curNum, long mul){
        if (index == len){
            if (curNum == target)
                ans.add(sb.toString());
            return;
        }
        int signIndex = sb.length();//插入符号的下标
        if (index > 0){
            sb.append('#'); //占位,下面填充符号
        }
        long val = 0;
        //
        for (int j = index; j < len && (j == index || num.charAt(index) != '0'); j++) {
            val = val * 10 + num.charAt(j) - '0';
            sb.append(num.charAt(j));
            if (index == 0){
                backtrack(sb, j + 1, val, val);
            }else {
                sb.setCharAt(signIndex, '+');
                backtrack(sb,j + 1, curNum + val, val);
                sb.setCharAt(signIndex, '-');
                backtrack(sb,j + 1, curNum - val, -val);
                sb.setCharAt(signIndex, '*');
                backtrack(sb, j + 1, curNum - mul + mul * val, mul * val);
            }
        }
        sb.setLength(signIndex);
    }
}
