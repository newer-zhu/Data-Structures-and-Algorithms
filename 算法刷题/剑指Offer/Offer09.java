package 剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Offer09 {

}

/**
 * LinkedList快一点
 */
class CQueue{
    ArrayDeque<Integer> d1;
    ArrayDeque<Integer> d2;

    public CQueue() {
        d1 = new ArrayDeque<Integer>();
        d2 = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        d1.push(value);
    }

    public int deleteHead() {
        if(d2.isEmpty()){
            while (!d1.isEmpty()){
                d2.push(d1.pop());
            }
        }else if (d1.isEmpty()){
            return -1;
        }
        return d2.pop();
    }
}