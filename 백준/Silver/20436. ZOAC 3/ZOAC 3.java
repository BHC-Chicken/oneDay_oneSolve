import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Pair> left = new HashMap<>();
        HashMap<String, Pair> right = new HashMap<>();
        int result = 0;

        left.put("q", new Pair(0, 0));
        left.put("w", new Pair(0, 1));
        left.put("e", new Pair(0, 2));
        left.put("r", new Pair(0, 3));
        left.put("t", new Pair(0, 4));
        right.put("y", new Pair(0, 5));
        right.put("u", new Pair(0, 6));
        right.put("i", new Pair(0, 7));
        right.put("o", new Pair(0, 8));
        right.put("p", new Pair(0, 9));

        left.put("a", new Pair(1, 0));
        left.put("s", new Pair(1, 1));
        left.put("d", new Pair(1, 2));
        left.put("f", new Pair(1, 3));
        left.put("g", new Pair(1, 4));
        right.put("h", new Pair(1, 5));
        right.put("j", new Pair(1, 6));
        right.put("k", new Pair(1, 7));
        right.put("l", new Pair(1, 8));

        left.put("z", new Pair(2, 0));
        left.put("x", new Pair(2, 1));
        left.put("c", new Pair(2, 2));
        left.put("v", new Pair(2, 3));
        right.put("b", new Pair(2, 4));
        right.put("n", new Pair(2, 5));
        right.put("m", new Pair(2, 6));

        String word = br.readLine();

        String leftStart = st.nextToken();
        String rightStart = st.nextToken();

        for (int i = 0; i < word.length(); i++) {
            Pair now;
            Pair prev;

            if (left.containsKey(word.charAt(i) + "")) {
                prev = left.get(leftStart);
                now = left.get(word.charAt(i) + "");

                leftStart = word.charAt(i) + "";
            } else {
                prev = right.get(rightStart);
                now = right.get(word.charAt(i) + "");

                rightStart = word.charAt(i) + "";
            }

            result += Math.abs(prev.x - now.x) + Math.abs(prev.y - now.y);
            result++;
        }

        System.out.println(result);
    }
}
