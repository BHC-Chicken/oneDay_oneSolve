class Solution {
    
    static int eucd(int a, int b) {
        int temp = a % b;
        if (temp == 0) {
            return b;
        } else {
            return eucd(b, temp);
        }
    }
    
    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return arr[0] * arr[1] / eucd(arr[1], arr[0]);
        }

        int lcm = arr[1] * arr[0] / eucd(arr[1], arr[0]);

        for (int i = 2; i < arr.length; i++) {
            lcm = lcm * arr[i] / eucd(lcm, arr[i]);
        }
        return lcm;
    }
}