class Solution {
    public int solution(String my_string, String is_suffix) {
        if (my_string.length() < is_suffix.length()) {
            return 0;
        }
        
        int index = my_string.length() - is_suffix.length();
        String word = my_string.substring(index, my_string.length());
        
        if (word.equals(is_suffix)) {
            return 1;
        }
        return 0;
    }
}