package 剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

//大数
public class Offer17 {
    public String[] printNumbers(int n) {
        //这里就溢出了
        String[] ans = new String[(int)(Math.pow(10, n)) - 1];
        Queue<String> q = new LinkedList<>();
        //将1~9加入队列
        for (int i = 1; i <= 9; i++){
            q.offer(String.valueOf(i));
        }
        int index = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                //将队列中的元素依次取出并加入答案
                String str = q.poll();
                ans[index++] = str;
                //若当前元素长度不够n，则在末尾补充0~9，继续加入队列
                if (str.length() < n){
                    for (int j = 0; j <= 9; j++){
                        q.offer(str + j);
                    }
                }
            }
        }
        return ans;
    }
}

class Solution {
    public static void main(String[] args) {
        new Solution().printNumbers(3);
    }
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;//假设n = 3
        res = new StringBuilder();
        num = new char[n]; //每次拼接末尾加上的数字
        start = n - 1;//数字截取[start， end),初始值是2
        dfs(0);
        //去掉逗号
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    //确定第x位及以后的值
    void dfs(int x) {
        if(x == n) {
            //去掉首0
            String s = String.valueOf(num).substring(start);
            //去掉特殊情况"000"
            if(!s.equals("0")) res.append(s + ",");
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
