package 剑指Offer;

import java.util.LinkedList;

//Offer59
public class MaxQueue {
    LinkedList<Integer> list = null;
    LinkedList<Integer> dull = null;//递减
    public MaxQueue() {
        list = new LinkedList<Integer>();
        dull = new LinkedList<Integer>();
    }

    public int max_value() {
        if (!dull.isEmpty())
            return dull.peekLast();
        else
            return -1;
    }

    public void push_back(int value) {
        while (!dull.isEmpty() && dull.peekFirst() < value){
            dull.pollFirst();
        }
        dull.addFirst(value);
        list.addLast(value);
    }

    public int pop_front() {
        if (list.isEmpty()) return -1;
        Integer pop = list.pollFirst();
        return pop.equals(dull.peekLast())? dull.pollLast() : pop;
    }
}
