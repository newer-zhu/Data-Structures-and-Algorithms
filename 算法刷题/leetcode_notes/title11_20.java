package leetcode_notes;

import java.util.Arrays;


public class title11_20 {
    /**11
     * 双指针法，从最外层两层边出发，每次移动较短边
     * 由于每次移动宽度肯定缩小，所以高度成为计算倾斜点
     * 移动后若高度不比原来，则无需计算，面积肯定变小
     * 如果移动左指针
     * 即无论我们怎么移动右指针，得到的容器的容量都小于移动前容器的容量。也就是说，这个左指针对应的数不会作为容器的边界了，那么我们就可以丢弃这个位置，将左指针向右移动一个位置，此时新的左指针于原先的右指针之间的左右位置，才可能会作为容器的边界。
     *
     */
    public static void main(String[] args) {
        int i = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }
    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int cul = Math.min(height[left], height[right]) * (right - left);
            max = max > cul? max : cul;
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }


    //12...........................................

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int ans;
        int cul;
        for (int step=1000; step > 0; step /= 10){
            if (num < step)
                continue;
            ans = num % step;
            cul = num - ans;
            num -= cul;
            switch (cul){
                case 0:
                    break;
                case 4:
                    sb.append("IV");
                    break;
                case 9:
                    sb.append("IX");
                    break;
                case 40:
                    sb.append("XL");
                    break;
                case 90:
                    sb.append("XC");
                    break;
                case 400:
                    sb.append("CD");
                    break;
                case 900:
                    sb.append("CM");
                    break;
                default:
                    sb.append(res(cul));
            }
        }
        return sb.toString();
    }

    public String res(int num){
        StringBuilder sb = new StringBuilder();
        String l = "" + num;
        int length = l.length();
        switch (length){
            case 1 :
                if (num < 4){
                    for (int i = 0; i< num; i++)
                        sb.append("I");
                }else {
                    sb.append("V");
                    for (int i = 0; i< num - 5; i++)
                        sb.append("I");
                }
                break;
            case 2:
                if (num < 40){
                    for (int i = 0; i < num/10; i++)
                        sb.append("X");
                }else {
                    sb.append("L");
                    for (int i = 0; i < (num - 50)/10; i++)
                        sb.append("X");
                }
                break;
            case 3:
                if (num < 400){
                    for (int i = 0; i< num/100; i++)
                        sb.append("C");
                }else {
                    sb.append("D");
                    for (int i = 0; i < (num - 500)/100; i++)
                        sb.append("C");
                }
                break;
            case 4:
                for (int i = 0; i < num/1000; i++)
                    sb.append("M");
        }
        return sb.toString();
    }
}
