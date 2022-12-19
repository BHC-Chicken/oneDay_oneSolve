import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int loop = Integer.parseInt(br.readLine());

        int[][] arr = new int[100][100];

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    arr[a + y][b + z] = 1;
                }
            }
        }

        int count = (int) Arrays.stream(arr).flatMapToInt(Arrays::stream)
                .filter(a -> a == 1)
                .count();

        System.out.println(count);
    }
}