package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr ={1,15,0,91,-32,45};
        int temp = 0;//索引

        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-1-i; j++) {
                //交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i:arr){
            System.out.print(i+" ");
        }


        /**
         * 优化
         */
        boolean flag = false;
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag == false)
                break;
            else
                flag = false;
        }
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
}
