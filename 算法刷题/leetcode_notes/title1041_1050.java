package leetcode_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class title1041_1050 {
    //title1046
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : stones)
            l.add(i);
        while (l.size() > 1){
            Collections.sort(l);
            Integer l1 = l.remove(l.size()-1);
            Integer l2 = l.remove(l.size()-1);
            int l3 = Math.abs(l1-l2);
            if (l3 != 0)
                l.add(l3);
        }
        return l.size()==0 ? 0 : l.get(0);
    }
}
