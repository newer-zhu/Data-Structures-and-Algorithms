package ArrayStack;

import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {

        ArrayStack numStack = new ArrayStack(10);
        CharStack charStack = new CharStack(10);

        int num1 = 0;
        int num2 = 0;
        //保存读到的符号
        char temp = ' ';
        //符号栈中取出的符号
        char ch = ' ';
        String multiNum = "";
        String expression = "3*2-3+6";
        for (int i=0; i<expression.length(); i++){
            temp = expression.charAt(i);//取出的符号或者数字
            if(charStack.isChar(temp)){
                try {
                    ch = charStack.getTop();
                }catch (NullPointerException e){//符号栈空直接入栈
                    charStack.push(temp);
                    continue;
                }
                //符号栈顶的优先级
                int top = charStack.priority(ch);
                // 读取到符号的优先级
                int tempNum = charStack.priority(temp);
                while (tempNum <= top && top != -1){
                    charStack.pop();//将栈中的符号先弹出
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    int cal = numStack.calculate(num2, num1, ch);
                    numStack.push(cal);
                    try {
                        ch = (char) charStack.getTop();
                        top = charStack.priority(ch);
                    }catch (NullPointerException e){
                        break;//符号栈中已经没有符号，跳出循环
                    }
                }
                //符号栈空时或temp优先级高时则直接压入temp
                charStack.push(temp);
            }else  {
                //累加多位数
                multiNum += temp;
//                如果后面是符号或已经是最后一次遍历则多位数入栈
                if (i == expression.length()-1 || charStack.isChar(expression.charAt(i+1))) {
                    int val = Integer.parseInt(multiNum);
                    multiNum = "";//清空
                    numStack.push(val);//转为数字压入栈时要减去48
                }
            }
        }
        //将符号栈中的符号全部弹出并运算
        do {
            ch = charStack.pop();
            num1 = numStack.pop();
            num2 = numStack.pop();
            int cal = numStack.calculate(num2, num1, ch);
            numStack.push(cal);
        }while (!charStack.isEmpty());

        System.out.println(numStack.pop());
    }
}
