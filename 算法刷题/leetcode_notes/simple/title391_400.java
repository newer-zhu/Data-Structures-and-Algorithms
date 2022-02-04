package leetcode_notes.simple;

import java.util.HashMap;
import java.util.List;

public class title391_400 {
    //title399
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int eqSize = equations.size();
        UnionFind uf = new UnionFind(2*eqSize);
        HashMap<String, Integer> map = new HashMap<>(2 * eqSize);
        int id = 0;
        for (int i = 0; i < eqSize; i++) {
            List<String> ls = equations.get(i);
            String s = ls.get(0);
            String l = ls.get(1);
            if (!map.containsKey(s))
                map.put(s, id++);
            if (!map.containsKey(l))
                map.put(l, id++);
            uf.union(map.get(s), map.get(l), values[i]);
        }

        int qSize = queries.size();
        double[] res = new double[qSize];
        for (int j = 0; j < qSize; j++) {
            String s = queries.get(j).get(0);
            String l = queries.get(j).get(1);
            Integer id1 = map.get(s);
            Integer id2 = map.get(l);
            if (id1 == null || id2 == null)
                res[j] = -1.0d;
            else
                res[j] = uf.isconnected(id1, id2);
        }
        return res;
    }

    private class UnionFind{
        private int[] parent;//节点的父节点
        private double[] values;//指向父节点的权值
        public UnionFind(int size){
            parent = new int[size];
            values = new double[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                values[i] = 1.0d;
            }
        }

        /**
         * 路径压缩
         * @param x
         * @return x的根节点
         */
        public int find(int x){
            if (x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                values[x] *= values[origin];
            }
            return parent[x];
        }

        /**
         * 并入树
         * @param s
         * @param l
         * @param v
         */
        public void union(int s, int l, double v){
            int rootS = find(s);
            int rootL = find(l);
            if (rootL == rootS)
                return;
            else{
                //设置为同一个父节点
                parent[rootS] = rootL;
                values[rootS] = values[l] * v / values[s];
            }
        }

        /**
         *
         * @param s
         * @param l
         * @return
         */
        public double isconnected(int s, int l){
            int rootS = find(s);
            int rootL = find(l);
            if (rootS == rootL )
                return values[s]/values[l];
            else
                return -1.0d;
        }
    }
}
