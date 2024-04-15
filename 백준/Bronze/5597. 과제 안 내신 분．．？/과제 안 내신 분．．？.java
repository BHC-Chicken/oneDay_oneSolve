import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[31];
        for (int i = 1; i <= 28; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
