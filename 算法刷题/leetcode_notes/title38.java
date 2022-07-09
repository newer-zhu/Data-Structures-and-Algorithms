package leetcode_notes;

/**
 * 38.外观数列
 */
public class title38 {
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        else {
            String s = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();//储存返回的结果
            int index = 0;//下标
            int count = 1;//计数器
            char num = s.charAt(index);
            while (index < s.length()){
                if (s == "1")
                    return "11";
                if ( s.charAt(index+1) == num) {
                    count++;
                    index++;
                    //最后一位与前面相同
                    if (index == s.length() - 1){
                        return sb.append(String.valueOf(count)+num).toString();
                    }
                } else {//如果后面的数字与前面的不相同
                    sb.append(String.valueOf(count)+num);
                    num = s.charAt(++index);
//                    最后一位与前面不相同
                    if (index == s.length() - 1){
                        return sb.append(String.valueOf("1"+num)).toString();
                    }
                    count = 1;//计数器回到1
                }
            }
            return sb.toString();
        }
    }
}
