package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1,0,-32,356,842,13,-426,10};
        sort(arr);
        System.out.println((Arrays.toString(arr)));
    }

    //获取最大值的位数
    public static int getMax(int[] arr){
        int max = arr[0];
        int digits ;
        for (int i=1; i<arr.length; i++){
            if (arr[i] > max){
                max = arr [i];
            }
        }
        for (digits = 0; max > 0; digits++){
            max /= 10;
        }
        return digits;
    }

    //获取最小值
    public static int getMin(int[] arr){
        int min = 0;
        for (int i=0; i<arr.length; i++){
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public static void sort(int[] arr){
            int min = getMin(arr);
//            将数组每个元素减去最小值
            for (int d=0; d<arr.length; d++){
                arr[d] -= min;
            }
            //定义桶
            int[][] bucket = new int[10][arr.length];
            //定义各个桶放入的数据个数
            int[] bucketNum = new int[10];

            for (int m=0,n=1; m<getMax(arr); m++,n*=10){
                for (int j=0; j<arr.length; j++){
                    //依次取出元素从低到高的位数值
                    int digit = Math.abs((arr[j] /n % 10));
                    //将元素对号入座
                    bucket[digit][bucketNum[digit]] = arr[j];
                    //记录桶里元素个数++
                    bucketNum[digit]++;
                }
                //将桶里的数据放回数组
                int index = 0;
                for (int i=0; i<bucketNum.length; i++){
                    //如果桶中有数据
                    if (bucketNum[i] != 0){
                        for (int l=0; l<bucketNum[i]; l++){
                            arr[index++] = bucket[i][l];
                        }
                    }
                    //记录清零
                    bucketNum[i] = 0;
                }
            }
            for (int i=0; i<arr.length; i++){
                arr[i] += min;
            }
    }

}
