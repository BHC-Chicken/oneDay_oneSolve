class Solution {
    public int solution(int n, int m, int[] section) {
        int[] arr = new int[n + 1];
        int count = 0;

        for (int j : section) {
            arr[j]++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                for (int j = i; j < m - 1; j++) {
                    arr[j] = 0;
                }
                i += (m - 1);
                count++;
            }
        }
        
        return count;
    }
}