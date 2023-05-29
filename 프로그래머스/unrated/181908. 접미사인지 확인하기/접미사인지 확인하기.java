class Solution {
    public int solution(String my_string, String is_suffix) {
        if (my_string.length() < is_suffix.length()) {
            return 0;
        }
        
        int index = my_string.length() - is_suffix.length();
        String word = my_string.substring(index, my_string.length());
        
        for (int i= 0; i < is_suffix.length(); i++) {
            if (word.charAt(i) != is_suffix.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }
}