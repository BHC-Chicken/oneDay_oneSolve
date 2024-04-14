import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[][] arr = new String[3][3];
            StringTokenizer st;

            for (int j = 0; j < 3; j++) {
                String[] s = br.readLine().split("");
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = s[k];
                }
            }

            boolean[] box = new boolean[8];

            box[0] = arr[0][0].equals("O");
            box[1] = arr[0][1].equals("O");
            box[2] = arr[0][2].equals("O");
            box[3] = arr[1][2].equals("O");
            box[4] = arr[2][2].equals("O");
            box[5] = arr[2][1].equals("O");
            box[6] = arr[2][0].equals("O");
            box[7] = arr[1][0].equals("O");

            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;

            for (int j = 0; j < box.length; j++) {
                if (box[j]) {
                    count++;
                }

                if (!box[j] && count > 0 || box[j] && j == box.length - 1) {
                    if (list.isEmpty() && count == 8) {
                        list.add(count);

                        break;
                    }

                    if (box[0] && box[j] && j == box.length - 1) {
                        list.set(0, list.get(0) + count);

                        break;
                    }

                    list.add(count);
                    count = 0;
                }
            }

            Collections.sort(list);

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if (n == 0 && list.isEmpty()) {
                sb.append(1).append("\n");

                continue;
            } else if (n != list.size()) {
                sb.append(0).append("\n");

                continue;
            }

            int[] input = new int[n];

            for (int j = 0; j < n; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input);

            boolean eq = true;

            if (input.length != list.size()) {
                sb.append(0).append("\n");
            } else {
                for (int j = 0; j < input.length; j++) {
                    if (input[j] != list.get(j)) {
                        eq = false;

                        break;
                    }
                }

                if (eq) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
