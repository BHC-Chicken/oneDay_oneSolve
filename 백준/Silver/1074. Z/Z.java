import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int r;
    static int c;
    static int result;

    static void divideAndConquer(int nr, int nc, int size) {
        if (size == 1) {
            System.out.println(result);

            return;
        }

        int newSize = size / 2;

        if (r < nr + newSize && c < nc + newSize) {
            divideAndConquer(nr, nc, newSize);
        }
        if (r < nr + newSize && nc + newSize <= c) {
            result += (size * size) / 4;
            divideAndConquer(nr, nc + newSize, newSize);
        }
        if (nr + newSize <= r && c < nc + newSize) {
            result += ((size * size) / 4) * 2;
            divideAndConquer(nr + newSize, nc, newSize);
        }
        if (nr + newSize <= r && nc + newSize <= c) {
            result += ((size * size) / 4) * 3;
            divideAndConquer(nr + newSize, nc + newSize, newSize);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        divideAndConquer(0, 0, size);
    }
}