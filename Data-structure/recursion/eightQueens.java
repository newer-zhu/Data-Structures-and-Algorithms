package recursion;

public class eightQueens {
    static int max = 8;
    static int count = 0;//记录解法
    static int[] location = new int[max];//皇后的位置数组

    /**
     * 判断第n个皇后是否与前面的冲突
     */
    private static boolean judge(int n){
        boolean flag = true;
        for (int i=0; i<n; i++){
            //1.两个皇后不能在同一列 2.两个皇后不能在同一斜线
            if (location[i] == location[n] || Math.abs(n-i) == Math.abs(location[n]-location[i]))
                flag = false;
        }
        return flag;
    }


    private static void solve(int n){
        //如果n等于8，说明放第9个皇后，此时已经解出了一种解法
        if (n == 8) {
            print();
            count++;
            return;
        }
        for(int i=0; i<max; i++){
            //把第n个皇后放在第i列
            location[n] = i;
            //如果不冲突，递归继续放第n+1个
            if (judge(n)){
                solve(n+1);
            }
            //如果冲突，当前的皇后向右移
        }
    }

    /**
     * 打印一种解法
     */
    private static void print(){
        for (int i = 0; i<location.length; i++){
            System.out.print(location[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solve(3);
        System.out.println(count);;
    }
}
