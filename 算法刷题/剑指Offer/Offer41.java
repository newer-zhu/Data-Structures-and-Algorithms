package 剑指Offer;

import java.util.PriorityQueue;

public class Offer41 {

    /** initialize your data structure here. */
    PriorityQueue<Double> queue1;
    PriorityQueue<Double> queue2;
    public Offer41() {
        //element最小值，储存较大的一半
        queue1 = new PriorityQueue<Double>();
        //element最大值，储存较小的一半
        queue2 = new PriorityQueue<Double>((o1, o2) -> Double.compare(o2, o1));
    }

    public void addNum(int num) {
        queue1.add(Double.valueOf(num));
        queue2.add(queue1.poll());
        if (queue1.size()+1 < queue2.size())
            //把queue2的最大值放到queue1去
            queue1.add(queue2.poll());
    }

    public double findMedian() {
        if (queue2.size() > queue1.size()){
            return queue2.element();
        }else {
            return (queue1.element()+queue2.element()) / 2;
        }
    }
}
