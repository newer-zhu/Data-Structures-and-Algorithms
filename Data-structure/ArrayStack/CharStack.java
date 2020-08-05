package ArrayStack;

import java.io.Serializable;
import java.util.HashSet;

public class CharStack {
    private int maxSize;
    private char[] stack;
    private int top = -1;

    public CharStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack =new char[this.maxSize];
    }

    /**
     * 获得栈顶元素，不弹出
     * @return
     */
    public Character getTop(){
        if (isEmpty()){
            return null;
        }
        return stack[top];
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
    public void push(char i){
        if (isFull()){
            System.out.println("满栈");
            return;
        }
        stack[++top] = i;
    }

    /**
     * 出栈
     */
    public Character pop(){
        if (isEmpty()){
            System.out.println("空栈");
            return null;
        }
        return stack[top--];
    }

    /**
     * 返回符号优先值
     */
    public int priority(char o){
        if (o == '*' || o == '/'){
            return 1;
        }else if (o == '+' || o == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 判断是不是运算符
     */
    public boolean isChar(char o){
        HashSet<Character> characters = new HashSet<>();
        characters.add('+');
        characters.add('-');
        characters.add('*');
        characters.add('/');
        return characters.contains(o);
    }

}
