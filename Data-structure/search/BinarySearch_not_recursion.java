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

    /**
     * 搜左侧边界
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchLeft(int[] arr ,int target){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                right = mid;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else if (arr[mid] > target){
                right = mid;
            }
        }
        //返回范围是[0, len], 表示小于target的元素数量
        if (left == arr.length) return -1;
        return arr[left] == target ? left : -1;
    }

    public static int binarySearchLeftRight(int[] arr ,int target){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                left = mid + 1;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else if (arr[mid] > target){
                right = mid;
            }
        }
        //返回范围是[0, len], 表示大于target的元素数量
        if (left == 0) return -1;
        return arr[left - 1] == target ? left - 1 : -1;
    }
}
