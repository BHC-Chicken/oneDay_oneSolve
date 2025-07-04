import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int zeroCount;
    static int result;

    static ArrayDeque<Pair> up = new ArrayDeque<>();
    static ArrayDeque<Pair> down = new ArrayDeque<>();

    static void containerMove() {
        up.addFirst(down.pollFirst());
        down.addLast(up.pollLast());

        up.peekLast().isRobot = false;
    }

    static void robotMove() {
        for (int i = 0; i < n - 1; i++) {
            Pair now = up.pollLast();
            Pair prev = up.peekLast();

            if (prev.isRobot && !now.isRobot && now.durability > 0) {
                now.durability--;
                now.isRobot = true;
                prev.isRobot = false;


                if (now.durability <= 0) {
                    zeroCount++;
                }
            }

            up.addFirst(now);
        }

        up.addFirst(up.pollLast());

        up.peekLast().isRobot = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        zeroCount = 0;
        result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            up.add(new Pair(Integer.parseInt(st.nextToken()), false));
        }

        for (int i = 0; i < n; i++) {
            down.addFirst(new Pair(Integer.parseInt(st.nextToken()), false));
        }

        while (zeroCount < k) {
            result++;

            containerMove();
            robotMove();

            if (up.peekFirst().durability > 0 && !up.peekFirst().isRobot) {
                up.peekFirst().durability--;
                up.peekFirst().isRobot = true;

                if (up.peekFirst().durability <= 0) {
                    zeroCount++;
                }
            }
        }

        System.out.println(result);
    }
}

class Pair {
    int durability;
    boolean isRobot;

    public Pair(int durability, boolean isRobot) {
        this.durability = durability;
        this.isRobot = isRobot;
    }
}
