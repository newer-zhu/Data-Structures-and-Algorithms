package sort;

import java.util.Arrays;

public class QuickSort {
    static int[] arr = {5,61,-23,-6,-21,-5,62,45};
    public static void main(String[] args) {
        quickSort(0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int l,int r){
        int left = l ;//左下标
        int right = r;//右下标
        int mid = arr[( left + right ) / 2];//中间数
        int temp = 0;

        while (left < right){
            while (arr[left] < mid){
                left++;
            }
            while (arr[right] > mid){
                right--;
            }
            if (left >= right){
                break;
            }
            //交换
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            if (arr[left] == mid){
                right--;
            }
            if (arr[right] == mid){
                left++;
            }
            if (left == right){
                left++;
                right--;
            }
            if (l < right){
                quickSort(l,right);
            }
            if (r > left){
                quickSort(left,r);
            }
        }
    }
}
