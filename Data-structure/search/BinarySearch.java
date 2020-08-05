package search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-6,-3,0,54,60,60,64,78};
        ArrayList<Integer> integers = BinarySearch(arr, 0, arr.length - 1, 300);
        System.out.println(integers.toString());

    }

    public static ArrayList<Integer> BinarySearch(int[] arr, int left, int right, int findVal){
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        ArrayList<Integer> integers = new ArrayList<>();

        if (left > right){
            integers.add(-1);
            return integers;
        } else if (findVal > midVal){
            return BinarySearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return BinarySearch(arr,left,mid-1,findVal);
        } else {
            integers.add(mid);
            int temp = mid - 1;
            while (temp > 0 && findVal == arr[temp]){
                integers.add(temp--);
            }
            temp = mid + 1;
            while (temp < arr.length && findVal == arr[temp]){
                integers.add(temp++);
            }
            return integers;
        }

    }
}
