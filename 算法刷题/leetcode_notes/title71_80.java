package leetcode_notes;

public class title71_80 {
    public static void main(String[] args) {
        int[][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        searchMatrix(a, 3);
    }
    //title74
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix[0].length;
        int m = matrix.length;
        int begin  =0, mid = 0, end =  m * n;
        while (begin < end){
            mid = (begin +  end) / 2;
            if (target > matrix[mid / n][mid % n]){
                begin = mid + 1;
            }else {
                end = mid;
            }
        }
        return matrix[begin / n][begin % n] == target;
    }

    //解法2
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
