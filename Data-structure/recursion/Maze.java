package recursion;

public class Maze {
    //初始化迷宫
    static int[][] maze = new int[8][8];
    public static void main(String[] args) {
        //1表示墙，0表示未被踩踏，2表示走过的路径，3表示走过后发现走不通
        for (int i=0; i<8; i++){
            maze[i][0] = 1;
            maze[i][7] = 1;
        }
        for (int i=0; i<8; i++){
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        maze[3][3] = 1;
        maze[3][4] = 1;
        maze[3][5] = 1;
        maze[3][6] = 1;

        show(maze);

        findWay2(1,1);

        System.out.println("-----------------------------------");
        show(maze);
        if (maze[6][5] == 2){
            System.out.println("到达终点");
        }else{
            System.out.println("没到终点");
        }
    }

    /**
     * 根据右，下，左，上的顺序来选择路线
     */
    public static boolean findWay(int i, int j){
        boolean flag = false;
        if (maze[6][5] == 2){
            return true;
        }else {
            switch (maze[i][j]){
                //如果从未被踩踏
                case 0:
                    maze[i][j] = 2;//假设可以通行
                    if (findWay(i,j+1)){//向右可以通行
                        flag = true;
                        break;
                    }else if (findWay(i+1,j)){//向下可以通行
                        flag = true;
                        break;
                    }else if (findWay(i,j-1)){//向左可以通行
                        flag = true;
                        break;
                    }else if (findWay(i-1,j)){//向上可以通行
                        flag = true;
                        break;
                    }
                    maze[i][j] = 3;//说明这点不可通行
                    return false;
                    //如果是墙
                case 1 :flag = false;
                    break;
                    //如果是走过的可行的路
                case 2 :flag = false;
                    break;
                    //如果是走过的不可行的路
                case 3 :flag = false;
                    break;
            }
            return flag;
        }
    }



    /**
     * 根据下，上，左，右的顺序来选择路线
     */
    public static boolean findWay2(int i, int j){
        boolean flag = false;
        if (maze[6][5] == 2){
            return true;
        }else {
            switch (maze[i][j]){
                //如果从未被踩踏
                case 0:
                    maze[i][j] = 2;//假设可以通行
                    if (findWay2(i+1,j)){//向下可以通行
                        flag = true;
                        break;
                    }else if (findWay2(i-1,j)){//向上可以通行
                        flag = true;
                        break;
                    }else if (findWay2(i,j-1)){//向左可以通行
                        flag = true;
                        break;
                    }else if (findWay2(i,j+1)){//向右可以通行
                        flag = true;
                        break;
                    }
                    maze[i][j] = 3;//说明这点不可通行
                    return false;
                //如果是墙
                case 1 :flag = false;
                    break;
                //如果是走过的可行的路
                case 2 :flag = false;
                    break;
                //如果是走过的不可行的路
                case 3 :flag = false;
                    break;
            }
            return flag;
        }
    }

    /**
     * 遍历显示迷宫
     * @param maze
     */
    public static void show(int[][] maze){
        for (int i=0; i<maze.length; i++){
            for (int j=0; j<maze[i].length; j++){
                System.out.printf("%d\t",maze[i][j]);
            }
            System.out.println();
        }
    }
}
