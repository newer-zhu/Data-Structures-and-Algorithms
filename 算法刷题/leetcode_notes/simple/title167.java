package leetcode_notes.simple;

public class title167 {
    public int[] twoSum(int[] numbers, int target) {
        int j = 0;
        int k = numbers.length - 1;
        while (j < k){
            int s = numbers[j] + numbers[k];
            if (s == target)
                return new int[]{j+1, k+1};
            else if (s < target)
                j++;
            else if (s > target)
                k--;
        }
        return null;
    }
}
