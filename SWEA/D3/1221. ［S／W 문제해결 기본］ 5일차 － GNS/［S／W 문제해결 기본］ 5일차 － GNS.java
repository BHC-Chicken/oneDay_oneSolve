import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        String[] arr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append("\n");

            int length = Integer.parseInt(st.nextToken());
            int[] sortArr = new int[length];
            String[] word = br.readLine().split(" ");

            for (int j = 0; j < length; j++) {
                switch (word[j]) {
                    case "ZRO" :
                        sortArr[j] = 0;
                        break;
                    case "ONE" :
                        sortArr[j] = 1;
                        break;
                    case "TWO" :
                        sortArr[j] = 2;
                        break;
                    case "THR" :
                        sortArr[j] = 3;
                        break;
                    case "FOR" :
                        sortArr[j] = 4;
                        break;
                    case "FIV" :
                        sortArr[j] = 5;
                        break;
                    case "SIX" :
                        sortArr[j] = 6;
                        break;
                    case "SVN" :
                        sortArr[j] = 7;
                        break;
                    case "EGT" :
                        sortArr[j] = 8;
                        break;
                    case "NIN" :
                        sortArr[j] = 9;

                }
            }

            Arrays.sort(sortArr);

            for (int j = 0; j < length; j++) {
                switch (sortArr[j]) {
                    case 0 :
                        sb.append(arr[0]).append(" ");
                        break;
                    case 1 :
                        sb.append(arr[1]).append(" ");
                        break;
                    case 2 :
                        sb.append(arr[2]).append(" ");
                        break;
                    case 3 :
                        sb.append(arr[3]).append(" ");
                        break;
                    case 4 :
                        sb.append(arr[4]).append(" ");
                        break;
                    case 5 :
                        sb.append(arr[5]).append(" ");
                        break;
                    case 6 :
                        sb.append(arr[6]).append(" ");
                        break;
                    case 7 :
                        sb.append(arr[7]).append(" ");
                        break;
                    case 8 :
                        sb.append(arr[8]).append(" ");
                        break;
                    case 9 :
                        sb.append(arr[9]).append(" ");

                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
