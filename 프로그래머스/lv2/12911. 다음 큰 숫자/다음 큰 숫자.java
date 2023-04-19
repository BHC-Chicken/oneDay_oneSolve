class Solution {
    public int solution(int n) {
        int binaryOrigin = Integer.bitCount(n);
        int binaryCount = 0;
        int binaryNext = n + 1;

        while (true) {
            binaryCount = Integer.bitCount(binaryNext);
            if (binaryCount == binaryOrigin) {
                break;
            }
            binaryNext += 1;
        }
        
        return binaryNext;
    }
}