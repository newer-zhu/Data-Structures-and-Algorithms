package 剑指Offer;

import common.TreeNode;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];
        int ans[] = new int[nums.length - k + 1];   // 记录每一窗口的最大值
        for (int i = 0; i + k - 1 < nums.length; i++) {
            if (i > 0 && nums[i + k - 1] > ans[i - 1]) ans[i] = nums[i + k - 1];    // 新值比上一窗口最大值大，返回 新值
            else if (i > 0 && nums[i - 1] < ans[i - 1]) ans[i] = ans[i - 1];    // 旧值比上一窗口最大值小，返回 上一窗口最大值
            else {   // 遍历滑动窗口，找到最大值
                int max = Integer.MAX_VALUE + 1;
                for (int j = i; j < i + k; j++) {
                    max = Math.max(max, nums[j]);
                    ans[i] = max;
                }
            }
        }
        return ans;
    }
}
