package leetcode_notes.simple;

/**
 * 算三角形面积
 * 考虑除数为0的条件，最后一行是关键！！！
 */
public class title1037 {
    public static void main(String[] args) {
        isBoomerang(new int[][]{{1,1},{2,2},{3,3}});
    }
    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0] - points[1][0];
        int y1 = points[0][1] - points[1][1];

        int x2 = points[0][0] - points[2][0];
        int y2 = points[0][1] - points[2][1];

        return x1 * y2 != x2 * y1;
    }
}
