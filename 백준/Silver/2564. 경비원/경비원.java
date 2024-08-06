import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static Pair dong;
    static Pair[] stores;

    static int result;

    static Pair position(int a, int b) {
        if (a == 1) {

            return new Pair(0, b);
        }

        if (a == 2) {

            return new Pair(m, b);
        }

        if (a == 3) {

            return new Pair(b, 0);
        } else {

            return new Pair(b, n);
        }
    }

    static int calPosition(int index) {
        int sum = 0;
        Pair store = stores[index];

        if (dong.x == 0 || dong.x == m) {
            int x = 0;
            int y = 0;

            if (dong.x == store.x) {
                return Math.abs(dong.y - store.y);
            } else if (store.y == 0) {
                if (dong.x == 0) {
                    x = store.x;
                } else {
                    x = m - store.x;
                }
                y = dong.y;
            } else if (store.y == n) {
                if (dong.x == 0) {
                    x = store.x;
                } else {
                    x = m - store.x;
                }
                y = n - dong.y;
            } else {
                x = m;
                y = Math.min(dong.y + store.y, (n - dong.y) + (n - store.y));
            }

            sum = x + y;
        } else if (dong.y == 0 || dong.y == n) {
            int x = 0;
            int y = 0;

            if (dong.y == store.y) {
                return Math.abs(dong.x - store.x);
            } else if (store.x == 0) {
                if (dong.y == 0) {
                    x = dong.x;
                    y = store.y;
                } else {
                    x = dong.x;
                    y = n - store.y;
                }
            } else if (store.x == m) {
                if (dong.y == 0) {
                    x = m - dong.x;
                    y = store.y;
                } else {
                    x = m - dong.x;
                    y = n - store.y;
                }
            } else {
                x = Math.min(dong.x + store.x, (m - dong.x) + (m - store.x));
                y = n;
            }

            sum = x + y;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int storeNum = Integer.parseInt(br.readLine());
        stores = new Pair[storeNum];

        for (int i = 0; i < storeNum; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stores[i] = position(x, y);
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        dong = position(x, y);

        for (int i = 0; i < storeNum; i++) {
            result += calPosition(i);
        }

        System.out.println(result);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
