package ArrayStack;

import java.util.HashSet;

public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack =new int[this.maxSize];
    }



    /**
     * 栈满
     */
    public boolean isFull(){
        return top == maxSize-1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈
     * @param i
     */
    public void push(int i){
        if (isFull()){
            System.out.println("满栈");
            return;
        }
        stack[++top] = i;
    }

    /**
     * 出栈
     */
    public Integer pop(){
        if (isEmpty()){
            System.out.println("空栈");
            return null;
        }
        return stack[top--];
    }
    /**
     * 计算
     */
    public int calculate(int num1, int num2, char o){
        int result = 0;
        switch (o){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "1";
        System.out.println(Integer.parseInt(s));
    }
}


