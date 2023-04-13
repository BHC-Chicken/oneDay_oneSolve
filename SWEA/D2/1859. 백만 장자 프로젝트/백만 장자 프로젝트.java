import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution
{
    static int[] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 1; i <= test_case; i++) {
            int size = Integer.parseInt(br.readLine());
            long max = Long.MIN_VALUE;
            int count = 0;
            long sum = 0;
            long result = 0;
            arr = new int[size];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = arr.length - 1; j >= 0; j--) { // 배열 뒤 부터 탐색
                if (max < arr[j]) {
                    result += (max * count - sum);
                    max = arr[j];
                    count = 0;
                    sum = 0;
                } else {
                    sum += arr[j];
                    count++;
                }
            }
            result += (max * count - sum);

            sb.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
	}
}