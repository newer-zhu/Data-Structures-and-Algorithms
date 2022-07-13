package leetcode_notes.medium;

import java.util.Arrays;

public class title131_140 {

    //title134
    // 一次遍历，如果到第k站正常，但无法到达k+1站，则把起始站设为第k+1站
    //为什么应该将起始站点设为k+1？
    //
    //因为k->k+1站耗油太大，0->k站剩余油量都是不为负的，每减少一站，就少了一些剩余油量。所以如果从k前面的站点作为起始站，剩余油量不可能冲过k+1站。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n  =  gas.length;
        int i = 0;
        while(i < n){
            int cargas= 0;
            int carcost = 0;
            int cnt = 0;
            while(cnt < n){
                int j = (i + cnt) % n;
                cargas += gas[j];
                carcost += cost[j];
                if(cargas < carcost){
                    break;
                }
                cnt++;
            }
            if(cnt == n){
                return i;
            }else{
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
