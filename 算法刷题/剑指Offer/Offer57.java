package 剑指Offer;

import java.util.ArrayList;

public class Offer57 {
    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for(int l = 1, r = 1, sum = 0; r <= target / 2 + 1; r++){
            sum += r;
            while (sum > target){
                sum -= l++;
            }
            if (sum == target){
                //构建连续数组
                int[] item = new int[r - l + 1];
                for (int i = 0; i < item.length; i++) {
                    item[i] = l+i;
                }
                res.add(item);
            }
        }

        int[][] ans = new int[res.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
