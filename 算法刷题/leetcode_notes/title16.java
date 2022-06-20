package leetcode_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class title16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int b = 1;
        int c = nums.length - 1;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for (int i=0; i < nums.length; i++){
            //保证和上一次枚举的a不同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //每次双指针都要清空上次的状态
            b = i + 1;
            c = nums.length - 1;
            while (b < c){
                sum = nums[i] + nums[b] + nums[c];//此次双指针指向的b，c和枚举的a的和
                if (sum == target) {//如果和target一样，直接返回
                    return target;
                }
                //如果此次sum与target的绝对值之差小于接近的答案与target的绝对值之差
                //则更新答案
                if (Math.abs(target - sum) < Math.abs(target - answer)){
                    answer = sum;
                }
                //双指针核心部分
                if (target < sum){
                    //跳过相同的指针
                    int c1 = c - 1;
                    while (b < c1 && nums[c1] == nums[c]){
                        c1--;
                    }
                    c = c1;
                } else {
                    int b1 = b - 1;
                    while (b1 < c && nums[b1] == nums[b]){
                        b1++;
                    }
                    b = b1;
                }
            }
        }
        return answer;
    }


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
