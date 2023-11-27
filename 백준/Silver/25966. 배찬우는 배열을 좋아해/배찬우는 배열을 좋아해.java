import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static void swap(int a, int b, int c) {
        int temp = arr[a][c];
        arr[a][c] = arr[b][c];
        arr[b][c] = temp;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        arr = new int[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int iter = 0; iter < query; iter++) {
            st = new StringTokenizer(br.readLine());

            int queryNum = Integer.parseInt(st.nextToken());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (queryNum == 0) {
                int num = Integer.parseInt(st.nextToken());

                arr[i][j] = num;
            } else {
                for (int k = 0; k < column; k++) {
                    swap(i, j, k);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
