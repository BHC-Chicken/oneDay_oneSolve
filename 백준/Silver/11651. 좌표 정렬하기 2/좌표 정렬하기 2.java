import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        int[][] arr = new int[loop][2];

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1];
            } else {
                return a1[0] - a2[0];
            }
        });

        for (int i = 0; i < loop; i++) {
            sb.append(arr[i][1]).append(" ").append(arr[i][0]).append("\n");
        }

        System.out.println(sb);
    }
}