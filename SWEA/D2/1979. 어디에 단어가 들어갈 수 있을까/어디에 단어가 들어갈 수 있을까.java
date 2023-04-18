import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution
{
    static int[][] arr;
    static int N, M, result;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 1; i <= test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;

            arr = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (count == M && arr[j][k] == 0) {
                        result++;
                        count = 0;
                        continue;
                    }
                    if (count != M && arr[j][k] == 0) {
                        count = 0;
                    }
                    if (arr[j][k] == 1) {
                        count++;
                    }
                }
                if (count == M) {
                    result++;
                }
            }

            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (count == M && arr[k][j] == 0) {
                        result++;
                        count = 0;
                        continue;
                    }
                    if (count != M && arr[k][j] == 0) {
                        count = 0;
                    }
                    if (arr[k][j] == 1) {
                        count++;
                    }
                }
                if (count == M) {
                    result++;
                }
            }
            sb.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }
}