package leetcode_notes.simple;

import java.util.ArrayList;
import java.util.HashSet;

public class title929 {
    public static void main(String[] args) {
        numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
    public static int numUniqueEmails(String[] emails) {
        ArrayList<StringBuilder> sbs = new ArrayList<>(emails.length);
        for (String s : emails){
            StringBuilder sb = new StringBuilder();
            String[] split = s.split("@");
            for (int i=0; i<split[0].length(); i++){
                char c = split[0].charAt(i);
                if (c == '+')
                    break;
                if (c != '.')
                    sb.append(c);
            }
            sb.append(split[1]);
            sbs.add(sb);
        }
        HashSet<String> set = new HashSet<>();
        for (StringBuilder s : sbs){
            set.add(s.toString());
        }
        return set.size();
    }
}
