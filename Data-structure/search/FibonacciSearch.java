package search;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {0,3,6,11,65,420};
        System.out.println(FiboSearch(arr,3));
    }

    /**
     * 获取斐波那契数列
     * @param max
     * @return
     */
    public static int[] getFi(int max){
        int[] arr = new int[max];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < max; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }

    public static int FiboSearch(int[] arr, int val){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;//中间值下标
        int[] fi = getFi(10);
        int k = 0;//斐波那契分割数下标
        while (high > fi[k] - 1){
            k++;
        }
        //fi[k]可能大于arr的长度，所以构造一个数组,此数组长度为fi[k]
        int[] temp = Arrays.copyOf(arr,fi[k]);
        //多出来的位置补上数组的最后一位
        for (int i=high+1; i<temp.length; i++){
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low + fi[k-1] - 1;
            if (val < temp[mid]){
                high = mid - 1;
                k--;
            }else if (val > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= high)
                    return mid;
                else
                    return high;
            }
        }
        return -1;
    }
}
