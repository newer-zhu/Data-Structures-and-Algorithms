package search;


public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int i = InsertSearch(arr, 0, arr.length - 1, 2);
        System.out.println(i);
    }

    public static int InsertSearch(int[] arr, int low, int high, int findVal){
        if (low > high || findVal < arr[0] || findVal > arr[arr.length-1]){
            return -1;
        }

        int mid = low + (high - low)*(findVal - arr[low]) / (arr[high] - arr[low]);
        int midVal = arr[mid];

        if (findVal > midVal){
            return InsertSearch(arr,mid+1,high,findVal);
        }else if (findVal < midVal){
            return InsertSearch(arr,low,mid - 1,findVal);
        }else {
            return mid;
        }
    }
}
