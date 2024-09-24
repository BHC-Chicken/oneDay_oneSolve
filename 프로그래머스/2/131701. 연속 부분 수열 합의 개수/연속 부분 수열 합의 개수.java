import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        
        for (int i = 0; i < elements.length; i++) {
            set.add(elements[i]);
            sum += elements[i];
        }
        
        set.add(sum);
        
        for(int i = 2; i < elements.length; i++) {
            int index = 0;
            
            while (index != elements.length) {
                sum = 0;
                for (int j = index; j < i + index; j++) {
                    sum += elements[(j + 1) % elements.length];
                }
                set.add(sum);
                index++;
            }
        }
        
        return set.size();
    }
}