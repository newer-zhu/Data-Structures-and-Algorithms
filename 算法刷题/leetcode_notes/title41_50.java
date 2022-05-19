package leetcode_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class title41_50 {


    //title48
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r=0; r < n /2; r++){
            for (int l=0; l < (n+1) / 2; l++){
                int temp = matrix[r][l];
                matrix[r][l] = matrix[n-1-l][r];
                matrix[n-1-l][r] = matrix[n-1-r][n-1-l];
                matrix[n-1-r][n-1-l] = matrix[l][n-1-r];
                matrix[l][n-1-r] = temp;
            }
        }
    }

}
