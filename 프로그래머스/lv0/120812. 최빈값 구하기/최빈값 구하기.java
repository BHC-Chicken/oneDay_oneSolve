class Solution {
    public int solution(int[] array) {
         int answer = 0;
        int value= 0;
        int[] arr = new int[1001];
        boolean flag = true;
        for (int j : array) {
            arr[j]++;
            if (arr[j] == value) {
                flag = false;
            } else if (arr[j] > value) {
                value = arr[j];
                answer = j;
                flag = true;
            }
        }
        if (!flag) {
            return -1;
        }
        return answer;
    }
}