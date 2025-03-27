import java.util.regex.*;

class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(s);
        if (m.find()){
            System.out.println(m.group());
        }
        return m.matches();
    }
}
