package sort;

import java.util.Arrays;

public class ShellSort {
    static int[] arr = {1,45,23,-1,0,-56,89,45,19,1,2};

    public static void main(String[] args) {
        /**
         * 位移法
         */
        int temp = 0;
        //一次循环结束重新确定步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                //将小的数插入到合适的位置
                if (arr[j] < arr[j - step]) {
                    while (j-step >=0 && temp < arr[j - step]){
                        arr[j] = arr[j-step];
                        j = j - step;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));


        //        /**
//         * 交换法
//         */
//        int temp = 0;
//        //一次循环结束重新确定步长
//        for (int step = arr.length/2; step>0; step/=2){
////            将每一对数据从前向后遍历
//            for (int i=step; i<arr.length; i++){
//                //对一对数据进行比较并排序，循环只执行一次
//                for (int j=i-step; j>=0; j-=step){
//                    if (arr[j] > arr[j+step]){
//                        temp = arr[j];
//                        arr[j] = arr[j+step];
//                        arr[j+step] = temp;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
