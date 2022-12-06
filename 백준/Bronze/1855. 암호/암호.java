import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int col = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int row = word.length() / col;
        char[][] alpha = new char[row][col];
        int count = 0;
        int r = 0;

        if (col == word.length()) {
            System.out.println(word);
            return;
        }

        for (int i = 0; i < col; i++) {
            alpha[r][i] = word.charAt(count);
            count++;
            if (i == col - 1) {
                r++;
                if (r == row) {
                    break;
                }
                for (i = col - 1; i >= 0; i--) {
                    alpha[r][i] = word.charAt(count);
                    count++;
                }
                r++;
            }
            if (r == row) {
                break;
            }
        }

        int c = 0;

        for (int i = 0; i < row; i++) {
            sb.append(alpha[i][c]);
            if (i == row - 1) {
                i = -1;
                c++;
            }
            if (c == col) {
                break;
            }
        }
        System.out.println(sb);
    }
}