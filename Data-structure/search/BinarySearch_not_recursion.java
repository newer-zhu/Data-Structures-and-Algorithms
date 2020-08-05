package search;

public class BinarySearch_not_recursion {
    /**
     * 默认升序
     * @param arr 数组
     * @param target 目标
     * @return 目标下标，-1为没找到
     */
    public static int binarySearch(int[] arr ,int target){
        int left = 0;
        int right = arr.length-1;

        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
