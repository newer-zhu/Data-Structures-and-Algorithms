import graph.Graph;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

public class Dijkstra {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        DGragh gragh = new DGragh(vertex, matrix);
        gragh.djs(0);
    }

}

class DGragh{
    private char[] vertex;
    private int[][] matrix;
    VisitedVertex vs;

    public DGragh(char[] vertex, int[][] matrix){
        this.matrix = matrix;
        this.vertex = vertex;
    }

    public void djs(int index){
        vs = new VisitedVertex(vertex.length, 0);
        update(index);
        for (int j=1; j < vertex.length; j++){
            index = vs.updateVertex();
            update(index);
        }
    }

    private void update(int index){
        int len = 0;
        for (int j = 0; j < vertex.length; j++){
            len = vs.getDist(index) + matrix[index][j];
            if (!vs.in(j) && len < vs.getDist(j)){
                vs.updateDist(j,len);//更新距离
                vs.updatePath(j, index);//更新路径
            }
        }
    }
}

class VisitedVertex{
    public static final int N = Integer.MAX_VALUE;
    public int[] path;//目前顶点的上一个顶点
    public int[] dist;//从起点到目前顶点的路径长度
    public int[] set;//是否加入到最短路径

    public VisitedVertex(int length, int index){
        this.path = new int[length];
        this.set = new int[length];
        this.dist = new int[length];

        Arrays.fill(dist, N);//初始都不通
        Arrays.fill(path, -1);
        this.set[index] = 1;//初始化节点已经被加入最短路径
        this.dist[index] = 0;//初始距离为0
    }

    //判断是否在最短路径内
    public boolean in(int index){
        return set[index] == 1;
    }

    //更新dist的值
    public void updateDist(int index, int len){
        dist[index] = len;
    }

    //更新path的值
    public void updatePath(int index, int pre){
        path[index] = pre;
    }

    public int getDist(int index){
        return dist[index];
    }

    //从剩余顶点中选择最近的顶点并返回
    public int updateVertex(){
        int min = N, index = 0;
        for (int i = 0; i < set.length; i++){
            if (set[i] == 0 && dist[i] < min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

}
