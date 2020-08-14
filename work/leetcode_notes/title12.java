package leetcode_notes;

/**
 * 大错特错，思路应该是贪心
 * 找到最大值的罗马字母，然后减去该值，继续
 */
public class title12 {
    public static void main(String[] args) {
        title12 title12 = new title12();
        String s = title12.intToRoman(58);
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int ans;
        int cul;
        for (int step=1000; step > 0; step /= 10){
            if (num < step)
                continue;
             ans = num % step;
             cul = num - ans;
             num -= cul;
             switch (cul){
                 case 0:
                     break;
                 case 4:
                     sb.append("IV");
                     break;
                 case 9:
                     sb.append("IX");
                     break;
                 case 40:
                     sb.append("XL");
                     break;
                 case 90:
                     sb.append("XC");
                     break;
                 case 400:
                     sb.append("CD");
                     break;
                 case 900:
                     sb.append("CM");
                     break;
                 default:
                     sb.append(res(cul));
            }
        }
        return sb.toString();
    }

    public String res(int num){
        StringBuilder sb = new StringBuilder();
        String l = "" + num;
        int length = l.length();
        switch (length){
            case 1 :
                if (num < 4){
                    for (int i = 0; i< num; i++)
                        sb.append("I");
                }else {
                    sb.append("V");
                    for (int i = 0; i< num - 5; i++)
                        sb.append("I");
                }
                break;
            case 2:
                if (num < 40){
                    for (int i = 0; i < num/10; i++)
                        sb.append("X");
                }else {
                    sb.append("L");
                    for (int i = 0; i < (num - 50)/10; i++)
                        sb.append("X");
                }
                break;
            case 3:
                if (num < 400){
                    for (int i = 0; i< num/100; i++)
                        sb.append("C");
                }else {
                    sb.append("D");
                    for (int i = 0; i < (num - 500)/100; i++)
                        sb.append("C");
                }
                break;
            case 4:
                for (int i = 0; i < num/1000; i++)
                    sb.append("M");
        }
        return sb.toString();
    }
}
