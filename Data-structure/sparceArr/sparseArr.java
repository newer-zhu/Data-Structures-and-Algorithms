package sparceArr;

import java.io.*;

public class sparseArr {

    public static void main(String[] args) {
        int[][] arr = new int[11][11];//创建一个原数组
        arr[1][2] = 1;//初始化原数组条件
        arr[2][3] = 2;
        arr[3][5] = 4;
        arr[5][6] = 5;
        int count = 0;//记录数组里有效数字的个数
        for (int[] row:arr){
            for (int item:row){
                System.out.print(item+"\t");//遍历输出数组
                if (item != 0)
                    count++;//计数有效数字
            }
            System.out.println();
        }

        int[][] sparseArrOut = new int[count+1][3];//根据count创建稀疏数组
        sparseArrOut[0][0] = 11;
        sparseArrOut[0][1] = 11;
        sparseArrOut[0][2] = count;//第一行的初始化

        int k=1;//稀疏数组记录有效值的行数
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                if (arr[i][j] != 0){       //进行列的赋值
                    sparseArrOut[k][2] = arr[i][j];
                    sparseArrOut[k][0] = i;
                    sparseArrOut[k][1] = j;
                    k++;
                }
            }
        }
        try {
            //将数组写出到磁盘上
            FileWriter os = new FileWriter(new File("E:/a.txt"));
            for (int[] row : sparseArrOut){
                for (int item : row){
                    os.write(item+"\t");
                }
                os.write("\r\n");
            }
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------");
        //读入稀疏数组
        int[][] sparseArrIn = new int[count+1][3];
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("E:/a.txt")));
            String line;
            int row = 0;//行数
            while ((line = br.readLine()) != null){
                String[] temp = line.split("\t");
                for (int j=0; j<temp.length; j++){
                    sparseArrIn[row][j] = Integer.parseInt(temp[j]);
                }
                row++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int[] row : sparseArrIn) {//遍历输出
            for (int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------");

        //还原数组
        int[][] origin = new int[sparseArrIn[0][0]][sparseArrIn[0][1]];//创建空的原数组
        for (int i=1; i<sparseArrIn.length; i++){
            origin[sparseArrIn[i][0]] [sparseArrIn[i][1]] = sparseArrIn[i][2];//将数组还原
        }

        for (int[] row1 : origin){//遍历输出
            for (int item : row1){
                System.out.print(item+"\t");
            }
            System.out.println();
        }
    }
}

