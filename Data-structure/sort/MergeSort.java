package sort;

import java.util.Arrays;

public class MergeSort {
    static int[] arr = {8,4,35,-3,23,0,-12,1};

    public static void merge(int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;//temp数组的索引

        //把数组的数据有序放入temp
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        //数组中有一边有剩余
        while (i <= mid){
            temp[t++] = arr[i++];
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }

        //temp数组复制到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft++] = temp[t++];
        }
    }

    public static void process(int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            process(left,mid,temp);
            process(mid+1,right,temp);
            merge(left,mid,right,temp);
        }
    }

    public static void main(String[] args) {
        process(0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
}
