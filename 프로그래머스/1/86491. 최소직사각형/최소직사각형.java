class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] card : sizes) {
            int w = card[0];
            int h = card[1];

            int longSide = Math.max(w, h);
            int shortSide = Math.min(w, h);

            maxWidth = Math.max(maxWidth, longSide);
            maxHeight = Math.max(maxHeight, shortSide);
        }

        return maxWidth * maxHeight;
    }
}