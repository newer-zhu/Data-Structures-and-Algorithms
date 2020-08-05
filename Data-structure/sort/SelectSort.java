package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {0,66,-3,15,43,82};
        for (int i=0; i<arr.length-1; i++){
            //暂定最小值和最小值索引为i
            int min = arr[i];
            int minIndex = i;
//            从i后面的数找出最小值并交换
            for (int j=i+1; j<arr.length; j++){
                if (min > arr[j]){
                    min = arr[j];//重置最小值
                    minIndex = j;//最小值的索引更新
                }
            }
            //交换值
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
}
