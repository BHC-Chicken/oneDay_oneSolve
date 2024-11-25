class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = -1;

        int[] answer = new int[2];

         while (start < sequence.length) {
             while (end < sequence.length && sum < k) {
                 sum += sequence[end];
                 end += 1;
             }

             if (sum == k) {
                 if (length == - 1 || length > end - start) {
                     answer[0] = start;
                     answer[1] = end - 1;
                     length = end - start;
                 }
             }

             sum -= sequence[start];
             start += 1;
         }
        
        return answer;
    }
}