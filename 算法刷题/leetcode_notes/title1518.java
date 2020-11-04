package leetcode_notes;

public class title1518 {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }

    public static int  numWaterBottles(int numBottles, int numExchange) {
        return numWaterBottle(numBottles,numExchange,0);
    }

    public static int numWaterBottle(int numBottles, int numExchange,int left) {
        int drink = numBottles;//给多少瓶先喝多少瓶
        int change = (numBottles + left)/numExchange;//能拿去换几瓶
        if (change <= 0)//如果不能换直接返回
            return drink;
        drink += numWaterBottle(change,numExchange,(numBottles + left) % numExchange);//将剩余的瓶子传递给下一次递归
        return drink;
    }
}
