package leetcode_notes;

public class title1781_1790 {
    //title1781
    public int beautySum(String s) {
        int length=s.length();
        int sum=0;
        for(int k=3;k<=length;k++){
            int l=0;
            int r=0;
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int[] count=new int[26];

            while(r<length){
                count[s.charAt(r)-'a']++;
                r++;
                while(l+k==r){
                    //出现次数最多-出现次数最少
                    min=Integer.MAX_VALUE;
                    max=Integer.MIN_VALUE;
                    for(int i=0;i<26;i++){
                        if(count[i]>0){
                            min=Math.min(min,count[i]);
                            max=Math.max(max,count[i]);
                        }
                    }
                    sum+=max-min;

                    count[s.charAt(l)-'a']--;
                    l++;
                }
            }
        }
        return sum;
    }
}
