import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        int index = 0;
        Arrays.sort(people);

        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
                count++;
            } else {
                count++;
            }
        }
        return count;
    }
}