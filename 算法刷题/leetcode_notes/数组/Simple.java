package leetcode_notes.数组;

import common.ListNode;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Simple {

    //36
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] region = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.'){
                    int index = board[i][j] - '0'-1;
                    row[i][index]++;
                    col[j][index]++;
                    region[i/3][j/3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || region[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //80
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int slow = 2, fast = 2;
        for (; fast < nums.length; fast++) {
            if (nums[slow-2] != nums[fast]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    //1636
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort((o1, o2) -> {
            if (map.get(o1) == map.get(o2)){
                return o2-o1;
            }
            return map.get(o1) - map.get(o2);
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
