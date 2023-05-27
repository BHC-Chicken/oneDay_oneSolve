class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        char [] ch = my_string.toCharArray();
        for (int i : index_list) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}