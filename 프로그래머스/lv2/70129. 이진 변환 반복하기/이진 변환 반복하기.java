class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int trance = 0;
        StringBuilder sb = new StringBuilder(s);

        while (!sb.toString().equals("1")) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    sb.replace(i, i + 1, "");
                    zero++;
                    i--;
                }
            }
            String num = Integer.toBinaryString(sb.length());
            sb.setLength(0);
            sb.append(num);
            trance++;
        }
        int[] answer = {trance, zero};
        
        return answer;
    }
}