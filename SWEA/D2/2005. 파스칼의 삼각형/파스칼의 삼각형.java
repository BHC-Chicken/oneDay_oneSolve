import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 1; i <= test_case; i++) {
            int num = Integer.parseInt(br.readLine());
            int[][] arr = new int[num][num];
            StringBuilder temp = new StringBuilder();
            arr[0][0] = 1;

            for (int j = 1; j < num; j++) {
                arr[j][0] = 1;
                for (int k = 1; k <= j - 1; k++) {
                    arr[j][k] = arr[j - 1][k - 1] + arr[j - 1][k];
                }
                arr[j][j] = 1;
            }

            for (int j = 0; j < num; j++) {
                for (int k = 0; k < j + 1; k++) {
                    temp.append(arr[j][k]).append(" ");
                }
                temp.append("\n");
            }

            sb.append("#").append(i).append("\n").append(temp);
        }
        System.out.println(sb);
    }
}