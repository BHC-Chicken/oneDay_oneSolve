class Solution {
    static int zeroCount = 0;
    static int oneCount = 0;
    
    static boolean search(int[][] arr, int startX, int startY, int endX, int endY) {
        int num = arr[startX][startY];

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (num != arr[i][j]) {
                    return false;
                }
            }
        }

        if (num == 1) {
            oneCount++;
        } else {
            zeroCount++;
        }

        return true;
    }

    static void divide(int[][] arr, int startX, int startY, int endX, int endY) {
        if (!search(arr, startX, startY, endX, endY)) {
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2;

            divide(arr, startX, startY, midX, midY);
            divide(arr, startX, midY, midX, endY);
            divide(arr, midX, startY, endX, midY);
            divide(arr, midX, midY, endX, endY);
        }
    }
    public int[] solution(int[][] arr) {
        divide(arr, 0, 0, arr.length, arr.length);

        return new int[]{zeroCount, oneCount};
    }
}