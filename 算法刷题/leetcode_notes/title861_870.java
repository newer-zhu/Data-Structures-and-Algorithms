package leetcode_notes;

import java.util.HashMap;

public class title861_870 {
    public boolean lemonadeChange(int[] bills) {
        int d5 = 0, d10 = 0;
        for (int i=0; i<bills.length; i++){
            if (bills[i] == 5){
                d5++;
            }else if (bills[i] == 10){
                d10++;
                d5--;
                if (d5 < 0)
                    return false;
            }else {
                if (d10 == 0){
                    d5 -= 3;
                }else {
                    d5--;d10--;
                }
                if (d5 < 0 || d10 < 0)
                    return false;
            }
        }
        return true;
    }
}
