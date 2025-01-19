import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i < elements.length; i++) {

            for (int j = 0; j < elements.length; j++) {
                for (int k = j; k < i + j; k++) {
                    int index = k % elements.length;

                    sum += elements[index];
                }

                set.add(sum);
                sum = 0;
            }

        }

        for (int element : elements) {
            sum += element;
        }

        set.add(sum);

        return set.size();
    }
}