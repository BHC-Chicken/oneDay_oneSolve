class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % 2 == 0) {
            int num = s.length() / 2 - 1;
            sb.append(s.substring(num, num + 2));
        } else {
            int num = s.length() / 2;
            sb.append(s.charAt(num));
        }
        return sb.toString();
    }
}