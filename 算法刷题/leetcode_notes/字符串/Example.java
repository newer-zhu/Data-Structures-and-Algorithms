package leetcode_notes.字符串;

import java.util.*;
import java.util.stream.Collectors;

public class Example {
    //t179
    public String largestNumber(int[] nums) {
        String str = Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((x, y) -> (y + x).compareTo(x + y))
                .collect(Collectors.joining(""));
        return str.charAt(0) == '0' ? "0" : str;
    }

    //title451
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public int findNthDigit(int n) {
        //d位数的总字符数
        int[] arr = new int[]{9,180,2700,36000,450000,5400000,63000000,720000000};
        //s[n]所在的位数
        int length = 1;
        for (int i = 0; i < 8; i++){
            if (n > arr[i]){
                n = n - arr[i];
                length ++;
            } else {
                break;
            }
        }
        //假设n是2680
        //基数，假设s[n]所在第数是三位数，则baseNum=100
        int baseNum = (int) Math.pow(10,length - 1);
        //每length个字符组成d位数的一个1，算出有几个1要在基数后面加
        //d位数必须 >= s[n]所在d位数真值，如144，145，146 s[n]在145的4中，则d位数必须是145
        int mod = n / length;
        //s[n]在d位数的偏移量
        int remain = n % length;
        if (remain == 0) {
            mod --;
            remain = length;
        }
        //d位数本身
        int num = baseNum + mod;
        return String.valueOf(num).charAt(remain - 1) - '0';
    }


    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (char c : magazine.toCharArray()){
            hash[c - 'a']++;
        }
        for (Character s : ransomNote.toCharArray()){
            if (hash[s - 'a']-- <= 0){
                return false;
            }
        }
        return true;
    }


}
