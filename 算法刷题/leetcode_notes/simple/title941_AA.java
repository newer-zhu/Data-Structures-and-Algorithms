package leetcode_notes.simple;

public class title941_AA {
    public boolean validMountainArray(int[] A) {
        int i;
        for(i=1;  i<A.length && A[i-1]<A[i]; i++);   //上山
        if(1 == i || i == A.length){ //上山爬不动或者一次就爬到终点
            return false;
        }

        for(;i<A.length && A[i-1]>A[i]; i++); //下山
        //下到山脚就是终点算你赢
        return (i == A.length);
    }
}
