import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] arr;

    static class Position {
        int left;
        int right;

        public Position(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static boolean check(Position pos) {
        while (pos.left <= pos.right) {
            if (arr[pos.left] == arr[pos.right]) {
                pos.left++;
                pos.right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            arr = br.readLine().toCharArray();

            Position pos = new Position(0, arr.length - 1);

            if (check(pos)) {
                sb.append(0).append("\n");
            } else {
                if (check(new Position(pos.left + 1, pos.right)) ||
                        check(new Position(pos.left, pos.right - 1))) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(2).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
