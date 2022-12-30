import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < loop - 1; i++) {
            int temp = num;
            int number = Integer.parseInt(st.nextToken());
            int max = Math.max(temp, number);
            int min = Math.min(temp, number);
            temp = ecud(max, min);
            sb.append(num / temp).append("/").append(number / temp).append("\n");
        }

        System.out.println(sb);
    }

    public static int ecud(int a, int b) {
        int temp = a % b;
        if (temp == 0) {
            return b;
        } else {
            return ecud(b, temp);
        }
    }
}