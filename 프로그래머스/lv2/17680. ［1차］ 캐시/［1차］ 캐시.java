import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> arrayList = new ArrayList<>();
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String s : cities) {
            if (arrayList.contains(s.toUpperCase())) {
                arrayList.remove(s.toUpperCase());
                arrayList.add(s.toUpperCase());
                answer++;
                continue;
            }
            if (arrayList.size() != cacheSize) {
                arrayList.add(s.toUpperCase());
                answer += 5;
            } else {
                arrayList.remove(0);
                arrayList.add(s.toUpperCase());
                answer += 5;
            }
        }
        return answer;
    }
}