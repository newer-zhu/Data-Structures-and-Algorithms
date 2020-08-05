package BinaryTree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9,12,-9,-3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        int temp = 0;
        for(int i=arr.length/2 - 1; i>=0; i--){
            formToHeap(arr,i,arr.length);
        }

        for (int j=arr.length-1; j>0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            formToHeap(arr,0,j);
        }
    }

    /**
     * 将一个数组调整成顶堆
     * @param i 非叶子节点在数组中的索引
     * @param length 对多少元素进行调整
     */
    public static void formToHeap(int[] arr,int i, int length){
        int temp = arr[i];//取出此元素
        //k是i的左子节点
        for (int k=2*i+1; k < length; k=2*k+1){
            //左子节点小于右子节点
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;//k指向右子节点
            }
            //子节点大于父节点
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;//i指向k，父节点向下
            }else {
                break;
            }
        }
        arr[i] = temp;
    }


}
