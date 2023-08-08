import java.util.List;

class Solution {
    public String solution(String[] seoul) {
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ").append(index).append("에 있다");

        return sb.toString();
    }
}