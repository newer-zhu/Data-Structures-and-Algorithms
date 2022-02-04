package leetcode_notes.图;

public class Example {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        //visited[x][y]说明此格子是否被踩过
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //每个格子都试着踩一遍
                if (dfs(board, visited, word, 0, m, n, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 参数分别是 原始数组，状态数组，字符串，当前比较下标，原始数组列数、行数，当前比较横坐标x，纵坐标y
     */
    public boolean dfs(char[][] board,boolean[][] visited, String s, int index, int m, int n, int x, int y) {
        if (index >= s.length()) {
            return true;//下标超过字符串长度说明全部比对完成
        }
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != s.charAt(index)) {
            return false;//字符比对失败或者当前踩出了边界
        }
        //如果当前格子没被踩过并且比对成功，就先设为已踩,然后继续向相邻格子方向走
        if (!visited[x][y] && board[x][y] == s.charAt(index)) {
            visited[x][y] = true;
            //四个方向有一条路通就行
            boolean res = dfs(board, visited, s, index + 1, m, n, x, y + 1) || dfs(board, visited, s, index + 1, m, n, x + 1, y)
                    || dfs(board, visited, s, index + 1, m, n, x, y - 1) || dfs(board, visited, s, index + 1, m, n, x - 1, y);
            visited[x][y] = false;
            return res;
        }
        return false;//被访问过，此路不通
    }
}
