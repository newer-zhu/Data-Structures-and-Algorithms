package sort;

import java.util.Arrays;

/**
 * 把数组分成两张表，一张有序，一张无序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,15,34,2,-1};
        //初始化
        int insertVal = 0;//要插入值
        int insertIndex = 0;//要插入的位置索引
        for (int i=1; i<arr.length; i++){
            insertVal = arr[i];
            insertIndex = i-1;//有序表的第一个值是arr[0]
            //从无序表中取出一个元素并在有序表中找到相应位置插入
            while (insertIndex >=0 && insertVal < arr[insertIndex] ){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
        System.out.println(Arrays.toString(arr));
        
    }
}
