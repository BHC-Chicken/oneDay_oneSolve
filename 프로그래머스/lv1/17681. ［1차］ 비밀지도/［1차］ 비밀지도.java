class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();

            String binary1 = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[i])));
            String binary2 = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr2[i])));

            for (int j = 0; j < n; j++) {
                if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            answer[i] = sb.toString();
        }
        return answer;
    }
}