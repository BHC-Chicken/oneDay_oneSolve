import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;

    static int recursive(int i, int j, int size) {
        if (size == 2) {
            int[] arr = new int[4];
            int index = 0;

            for (int k = i; k < i + 2; k++) {
                for (int l = j; l < j + 2; l++) {
                    arr[index++] = map[k][l];
                }
            }

            Arrays.sort(arr);

            return arr[2];
        }

        int[] arr = new int[4];
        size /= 2;

        arr[0] = recursive(i, j, size);
        arr[1] = recursive(i, j + size, size);
        arr[2] = recursive(i + size, j, size);
        arr[3] = recursive(i + size, j + size, size);

        Arrays.sort(arr);

        return arr[2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = recursive(0, 0, n);

        System.out.println(result);
    }
}
