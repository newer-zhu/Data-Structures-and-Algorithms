package leetcode_notes.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class title119 {
    public List<Integer> getRow(int rowIndex) {
        return triangle(rowIndex);
    }

    public ArrayList<Integer> triangle(int k){
        ArrayList<Integer> list = new ArrayList<>(k+1);
        list.add(1);
        if (k == 0){
            return list;
        }
        ArrayList<Integer> last = triangle(k - 1);
        for (int i=0; i<last.size()-1; i++){
            list.add(last.get(i)+last.get(i+1));
        }
        list.add(1);
        return list;
    }
}
