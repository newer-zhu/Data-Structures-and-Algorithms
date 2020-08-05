package ArrayStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Transfer {
    /**
     * 将表达式元素分割转换为List便于操作
     * @param str
     * @return
     */
    public static List<String> toList(String str){
        int i = 0;//索引
        ArrayList<String> list = new ArrayList<>();
        char c ;
        String mulNum = "";//多位数字符串
        for (i=0; i<str.length(); i++){
            c = str.charAt(i);
            //c是符号
            if (c > 57 || c < 48)
                list.add(""+c);
            //c是数字
            else{
                mulNum += c;
                if (i==str.length()-1 || str.charAt(i+1)>57 || str.charAt(i+1)<48) {
                    list.add(mulNum);
                    mulNum = "";
                }
            }
        }
        System.out.println(list);
        return list;
    }

    /**
     * 返回符号优先值
     */
    public static int priority(String o){
        if (o.equals("*") || o.equals("/") ){
            return 1;
        }else if (o.equals("+" ) || o.equals("-") ){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 转换成逆波兰表达式
     * @return
     */
    public static List toRPN(String str ){

        List<String> list = toList(str);
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();

        for (String s : list){
            //正则表达式，如果是一个数
            if (s.matches("\\d+")){
                s2.add(s);
                //如果s1空或者此符号是"(",直接进栈
            }else if (s1.isEmpty() || s.equals("(")){
                s1.push(s);
                //如果此符号是")"
            }else if (s.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//弹出"("
                //如果运算符优先级高于s1栈顶的元素或者栈顶元素是"(",直接进栈
            }else if (priority(s)>priority(s1.peek()) || s1.peek().equals("(")){
                s1.push(s);
                //运算符优先级低于或等于s1栈顶元素
            }else {
                while (!s1.isEmpty() && priority(s)<=priority(s1.peek()))
                    s2.add(s1.pop());
                s1.push(s);
            }
        }//s1中元素弹出并压入s2
        while (!s1.isEmpty()){
            s2.add(s1.pop());
        }
        System.out.println(s2);
        return s2;
    }

    public static boolean isChar(String o){
        HashSet<String> strings = new HashSet<>();
        strings.add("+");
        strings.add("-");
        strings.add("*");
        strings.add("/");
        return strings.contains(o);
    }
    public static int operation(int num1, int num2, String o){
        int result = 0;
        switch (o){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result = num1/num2;
                break;
        }
        return result;
    }
    /**
     * 计算后缀表达式
     */
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String s : list){
            if (isChar(s)){
                int o1 = Integer.parseInt(stack.pop());
                int o2 = Integer.parseInt(stack.pop());
                int val = operation(o2, o1, s);
                stack.push(String.valueOf(val));
            }else {
                stack.push(s);
            }
        }
        int result = Integer.parseInt(stack.peek());
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        List list = toRPN("5*2+(12+2)-2");
        calculate(list);
    }
}
