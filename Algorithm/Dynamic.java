/**
 * 背包问题
 * 一个容量固定的包，一些价值不同重量不同的物品，问装哪些物品可以装最贵的物品
 * （一种物品只能装一次）
 */
public class Dynamic {
    public static void main(String[] args) {
        int[] w = {1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价值
        int m = 4;//背包容量
        int n = val.length;//物品个数
        int[][] t = new int[n+1][m+1];//表格

        //第一行第一列设为0
        for (int i=0; i<val.length; i++){
            t[i][0] = 0;
            t[0][i] = 0;
        }

        /**
         * 行代表物品，列代表重量。都是动态变化的。
         * 如果当前物品的重量大于背包总量，则最大价值依然是上一行的同一列数据
         * 否则，先放入当前物品，在找上一行剩余重量下能装的最大价值物品。然后和直接上一行同一列比较
         */
        for (int i = 1; i < val.length; i++){
            for (int j=1; j < t[0].length; j++){
                if (w[i-1] > j){
                    t[i][j] = t[i-1][j];
                }else {
                    t[i][j] = Math.max(t[i-1][j],val[i-1]+t[i-1][j-w[i-1]]);
                }
            }
        }

    }
}
