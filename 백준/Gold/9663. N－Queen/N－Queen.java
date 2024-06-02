import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int ans;
    static public int totalNQueens() {
        solve(0, 0, 0, 0);

        return ans;
    }

    static public void solve(int row, int hills, int next_row, int dales) {
        int queens = (1 << N) - 1;
        if (row == queens) {
            ans++;
            return;
        }
        int positions = queens & (~(hills | next_row | dales));
        while (positions != 0) {
            int pos = positions & (-positions);
            positions -= pos;
            solve(row | pos, (hills | pos) << 1, next_row | pos, (dales | pos) >> 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = totalNQueens();

        System.out.println(result);
    }
}