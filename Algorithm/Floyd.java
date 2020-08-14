import java.util.Arrays;

public class Floyd {
    public static void main(String[] args) {

    }
}

class Graph {
    private char[] vertex;//存放顶点的数组
    private int[][] dis;//保存各个顶点出发到其他顶点的距离
    private int[][] pre;//保存到达目标顶点的中间节点

    /**
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex){
        this.dis = matrix;
        this.pre = new int[length][length];
        this.vertex = vertex;

        for (int i=0; i < length; i++){
            Arrays.fill(pre[i],i);
        }
    }

    public void show(int[][] arr){
        for (int k=0; k < dis.length; k++){
            System.out.println(Arrays.toString(arr[k]));
        }
    }

    public void floyd(){
        int len = 0;
        //中间顶点的遍历
        for (int k=0; k < dis.length; k++){
            //从i顶点开始出发
            for (int i=0; i < dis.length; i++){
                for (int j=0; j < dis.length; j++){
                    len = dis[i][k] + dis[k][j];//求出从i到k到j顶点的距离
                    if (len < dis[i][j]){
                        dis[i][j] = len;//更新距离
                        pre[i][j] = pre[k][j];//更新前驱节点
                    }
                }
            }
        }
    }
}