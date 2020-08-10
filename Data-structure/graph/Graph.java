package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static void main(String[] args) {
    }

    private ArrayList<String> vertexList;//节点
    private int[][] edges;//矩阵
    private int numOfEdges;//边数
    private boolean[] isVisited;//记录是否被访问过

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }



    //插入节点,每个节点都有下标
    public void insert(String s){
        vertexList.add(s);
    }

    /**
     * 添加边
     * @param v1 表示点的下标
     * @param v2 v2 第二个顶点的下标
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;//边的条数+1
    }

    //获取结点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //获取边的个数
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //获取结点i对应的数据
    public String getValByIndex(int i){
        return vertexList.get(i);
    }

    //返回权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] i : edges){
            System.out.println(Arrays.toString(i));
        }
    }

    //得到第一个邻接节点下标
    public int getFirstNeighbor(int index){
        for (int j=0; j < vertexList.size(); j++){
            if (edges[index][j] > 0)
                return j;
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2){
        for (int j = v2 + 1; j < vertexList.size(); j++){
            if (edges[v1][j] > 0)
                return j;
        }
        return -1;
    }

    //深度优先遍历DFS
    private void DFS(boolean[] isVisited,int i){
        //访问该节点并输出
        System.out.println(getValByIndex(i)+"->");
        isVisited[i] = true;//标记为访问过
        int j = getFirstNeighbor(i);//获取第一个邻接节点的下标
        while (j != -1){
            if ( !isVisited[j]){//如果j未被访问
                DFS(isVisited,j);
            }
            //如果j已经被访问
            j = getNextNeighbor(i,j);
        }
    }

    //DFS的重载，遍历所有的节点
    public void DFS(){
        isVisited = new boolean[vertexList.size()];
        for (int i=0; i < getNumOfVertex(); i++){
            if (! isVisited[i]){
                DFS(isVisited,i);
            }
        }
    }

    //广度优先BFS,对一个节点
    private void BFS(boolean[] isVisited,int i){
        int u;//队列头节点的下标
        int w;//邻接节点的下标
        LinkedList queue = new LinkedList();//队列记录访问节点的顺序
        System.out.println(getValByIndex(i)+"->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u = (int) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.println(getValByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    //BFS所有节点
    public void BFS(){
        isVisited = new boolean[vertexList.size()];
        for (int i=0; i<getNumOfVertex(); i++){
            if (!isVisited[i]){
                BFS(isVisited,i);
            }
        }
    }
}
