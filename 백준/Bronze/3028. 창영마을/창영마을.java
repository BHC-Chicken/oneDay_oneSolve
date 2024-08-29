import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("");
        int[] map = new int[3];
        map[0] = 1;

        for (String cmd : word) {
            if (cmd.equals("A")) {
                if (map[0] == 1) {
                    map[0] = 0;
                    map[1] = 1;
                } else if (map[1] == 1) {
                    map[0] = 1;
                    map[1] = 0;
                }
            } else if (cmd.equals("B")) {
                if (map[1] == 1) {
                    map[1] = 0;
                    map[2] = 1;
                } else if (map[2] == 1) {
                    map[1] = 1;
                    map[2] = 0;
                }
            } else {
                if (map[2] == 1) {
                    map[0] = 1;
                    map[2] = 0;
                } else if (map[0] == 1) {
                    map[0] = 0;
                    map[2] = 1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (map[i] == 1) {
                System.out.println(i + 1);

                break;
            }
        }
    }
}