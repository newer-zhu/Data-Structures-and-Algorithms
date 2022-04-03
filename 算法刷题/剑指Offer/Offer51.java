package 剑指Offer;

public class Offer51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    //返回逆序对数目
    private int reversePairs(int[] nums, int l, int r, int[] temp) {
        if (l == r)
            return 0;
        int mid = l + (r - l) / 2;
        int leftNum = reversePairs(nums, l, mid, temp);
        int rightNum = reversePairs(nums, mid + 1, r, temp);
        //此时【l，r】已经有序，无需合并
        if (nums[mid] <= nums[mid + 1]) {
            return leftNum + rightNum;
        }
        return leftNum + rightNum + mergeAndCount(nums, l, mid, r, temp);
    }

    //归并排序并统计
    private int mergeAndCount(int[] nums, int l, int mid, int r, int[] temp) {
        for (int i = l; i <= r; i++) {
            temp[i] = nums[i];
        }
        //指向两个有序子数组的指针
        int i = l, j = mid + 1;
        int count  = 0;

        //k指向原数组，进行归并排序
        for (int k = l; k <= r; k++) {
            //左边的子数组已经全部合并
            if (i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if (j == r + 1){//右边的已经全部合并
                nums[k] = temp[i];
                i++;
            }else if (temp[i] > temp[j]){//左指针元素大于右指针元素,注意这里用的是temp数组比较
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }
        }

        return count;
    }
}
