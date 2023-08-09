class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (s.charAt(i) + n > 'z') {
                    int temp = s.charAt(i) - 'z' + n - 1;
                    sb.append((char) ('a' + temp));
                } else {
                    sb.append((char) (s.charAt(i) + n));
                }
            } else if (s.charAt(i) == ' ') {
                sb.append(" ");
            } else {
                if (s.charAt(i) + n > 'Z') {
                    int temp = s.charAt(i) - 'Z' + n - 1;
                    sb.append((char) ('A' + temp));
                } else {
                    sb.append((char) (s.charAt(i) + n));
                }
            }
        }
        
        return sb.toString();
    }
}