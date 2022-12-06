import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            String space = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer sejun = new StringTokenizer(br.readLine());
            StringTokenizer sebin = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> S = new PriorityQueue<>();
            PriorityQueue<Integer> B = new PriorityQueue<>();

            while (sejun.hasMoreTokens()) {
                S.add(Integer.parseInt(sejun.nextToken()));
            }
            while (sebin.hasMoreTokens()) {
                B.add(Integer.parseInt(sebin.nextToken()));
            }

            while (!S.isEmpty() && !B.isEmpty()) {
                if (S.peek() > B.peek()) {
                    B.poll();
                } else if (S.peek() < B.peek()) {
                    S.poll();
                } else if (S.peek().equals(B.peek())) {
                    B.poll();
                }
            }

            if (S.isEmpty()) {
                System.out.println("B");
            } else if (B.isEmpty()) {
                System.out.println("S");
            } else {
                System.out.println("C");
            }
        }
    }
}