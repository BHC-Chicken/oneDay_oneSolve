import java.util.List;

class Solution {
    public String solution(String[] seoul) {
        List<String> list = List.of(seoul);
        int index = list.indexOf("Kim");
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ").append(index).append("에 있다");

        return sb.toString();
    }
}