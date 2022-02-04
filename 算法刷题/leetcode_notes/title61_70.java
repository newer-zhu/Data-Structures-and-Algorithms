package leetcode_notes;

public class title61_70 {
//    title62=================
    public static int uniquePaths(int m, int n) {
//        (1)迭代
        int[][] path = new int[m][n];
        for (int i = 0; i < n; i++)
            path[0][i] = 1;
        for (int j = 0; j < m; j++)
            path[j][0] = 1;
        for (int k = 1; k < m; k++){
            for (int d = 1; d < n; d++){
                path[k][d] = path[k-1][d] + path[k][d-1];
            }
        }
        return path[m-1][n-1];
        //(2)递归
//        if (m == 0 || n == 0)
//            return 0;
//        int[][] graph = new int[m][n];
//        if ((m == 1 && n == 2) || (m == 2 && n == 1))
//            return 1;
//        return uniquePaths(m,n-1) + uniquePaths(m-1,n);
    }

}
