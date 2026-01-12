class Solution {
    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        
        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }

                matrix[x][y] = num++;
            }
        }

        int[] answer = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}