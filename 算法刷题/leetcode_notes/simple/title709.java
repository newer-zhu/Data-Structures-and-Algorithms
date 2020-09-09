package leetcode_notes.simple;

public class title709 {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if (c >= 65 && c <= 90){
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
