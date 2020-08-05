package leetcode_notes;

import java.util.ArrayList;

public class title155 {
    class MinStack {
        ArrayList<Integer> stack;
        int index = 0;
        ArrayList<Integer> min;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayList<>();
            min = new ArrayList<>();
        }

        public void push(int x) {
            stack.add(index,x);
            if (index == 0)
                min.add(x);
            else {
                if (min.get(min.size()-1) > x)
                    min.add(x);
            }
            index++;
        }

        public void pop() {
            if (index > 0) {
                Integer remove = stack.remove(index--);
                if (remove < min.get(min.get(min.size()-1)))
                    min.remove(min.get(min.size()-1));
            }
        }

        public int top() {
                return stack.get(index--);
        }

        public int getMin() {
            Integer integer = min.get(min.size() - 1);
            return integer;
        }
    }
}
