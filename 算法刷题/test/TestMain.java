package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Hodor_Zhu
 * @description
 * @date: 2024/9/3 22:11
 */
public class TestMain {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int res = 0;
        int start = res;
        while (true){
            tank += gas[start];
            if (tank < cost[start]){
                start = res = (start+1) % gas.length;
                tank = 0;
                if (start == 0) return -1;
            }else {
                tank -= cost[start];
                start = (start+1) % gas.length;
                if (start == res) return res;
            }
        }
    }




}
