public class DividedConquer {
    public static void main(String[] args) {
        Hanoitower(2,'a','b','c');
    }
    /**
     * 汉诺塔
     * @param num 盘子个数
     * @param a a塔
     * @param b b塔
     * @param c c塔
     */
    public static void Hanoitower(int num, char a, char b, char c){
        if (num == 1){
            System.out.println("第1个盘从 "+ a + "->" + c);
        }else {
            //大于1个盘看成最下面的一个盘和剩余上面的盘
            //先把最上面的所有盘从a移到b，过程中利用了c
            Hanoitower(num - 1, a, c, b);
            //把最下面的盘从a移到c
            System.out.println("第"+ num + "个盘从 " + a + "->" + c);
            //把b塔的所有盘移到c
            Hanoitower(num-1,b ,a ,c);

        }
    }
}
