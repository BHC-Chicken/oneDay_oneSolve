import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {
    ArrayList<String> list = new ArrayList<>();

        s = s.substring(2);
        s = s.substring(0, s.length() - 2).replace("},{", "-");

        String[] word = s.split("-");

        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String a : word) {
            String[] last = a.split(",");
            for (String t : last) {
                if (!list.contains(t)) {
                    list.add(t);
                }
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}