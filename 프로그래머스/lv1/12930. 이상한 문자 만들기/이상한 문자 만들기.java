import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            for (int i = 0; i < word.length(); i++) {
                if(i % 2 == 0) {
                    sb.append(String.valueOf(word.charAt(i)).toUpperCase());
                } else {
                    sb.append(String.valueOf(word.charAt(i)).toLowerCase());
                }
            }
        }
        return sb.toString();
    }
}