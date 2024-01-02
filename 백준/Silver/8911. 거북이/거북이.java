import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String word = br.readLine();

            int left = 0;
            int right = 0;
            int top = 0;
            int bottom = 0;

            int dir = 0;
            int x = 0;
            int y = 0;

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                switch (c) {
                    case 'F':
                        x += dirX[dir];
                        y += dirY[dir];
                        break;
                    case 'R':
                        dir = (dir + 1) % 4;
                        break;
                    case 'L':
                        dir = (dir + 3) % 4;
                        break;
                    case 'B':
                        x -= dirX[dir];
                        y -= dirY[dir];
                }

                top = Math.max(top, y);
                right = Math.max(right, x);
                bottom = Math.min(bottom, y);
                left = Math.min(left, x);

            }
            int vertical = Math.abs(top) + Math.abs(bottom);
            int horizontal = Math.abs(left) + Math.abs(right);

            sb.append(vertical * horizontal).append("\n");
        }

        System.out.println(sb);
    }
}
