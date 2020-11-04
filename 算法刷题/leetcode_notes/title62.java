package leetcode_notes;

public class title62 {
    public static void main(String[] args) {
        int i = uniquePaths(23, 12);
        System.out.println(i);
    }
    public static int uniquePaths(int m, int n) {
//        if (m == 0 || n == 0)
//            return 0;
//        int[][] graph = new int[m][n];
//        if ((m == 1 && n == 2) || (m == 2 && n == 1))
//            return 1;
//        return uniquePaths(m,n-1) + uniquePaths(m-1,n);

        int[][] way = new int[m][n];
        for (int i = 0; i < m; i++){
            way[0][i] = 1;
        }
        for (int j = 0; j < n; j++){
            way[j][0] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j =1; j < n; j++){
                way[i][j] = way[i - 1][j] + way[i][j - 1];
            }
        }
        return way[m - 1][n - 1];
    }
}
