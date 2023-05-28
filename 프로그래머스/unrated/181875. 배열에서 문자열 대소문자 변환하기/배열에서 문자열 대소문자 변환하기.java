class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        boolean flag = true;
        int index = 0;
        for (String s : strArr) {
            if (flag) {
                answer[index] = s.toLowerCase();
                flag = false;
            } else {
                answer[index] = s.toUpperCase();
                flag = true;
            }
            index++;
        }
        
        return answer;
    }
}