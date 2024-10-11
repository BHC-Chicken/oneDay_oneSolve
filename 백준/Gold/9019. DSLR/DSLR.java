import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String start;
    static String goal;

    static int[] startNum;
    static int[] goalNum;

    static int leftShift(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    static int rightShift(int num) {
        return (num % 10) * 1000 + num / 10;
    }

    static int multi(int num) {
        return (num * 2) % 10000;
    }

    static int minus(int num) {
        if (num == 0) {
            return 9999;
        }


        return num - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            Queue<Pair> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];

            queue.add(new Pair(start, ""));
            visited[start] = true;

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();

                int d = multi(pair.num);
                int s = minus(pair.num);
                int l = leftShift(pair.num);
                int r = rightShift(pair.num);

                if (!visited[d]) {
                    if (d == goal) {
                        sb.append(pair.command).append("D").append("\n");

                        break;
                    }

                    queue.add(new Pair(d, pair.command + "D"));
                    visited[d] = true;
                }

                if (!visited[s]) {
                    if (s == goal) {
                        sb.append(pair.command).append("S").append("\n");

                        break;
                    }

                    queue.add(new Pair(s, pair.command + "S"));
                    visited[s] = true;
                }

                if (!visited[l]) {
                    if (l == goal) {
                        sb.append(pair.command).append("L").append("\n");

                        break;
                    }

                    queue.add(new Pair(l, pair.command + "L"));
                    visited[l] = true;
                }

                if (!visited[r]) {
                    if (r == goal) {
                        sb.append(pair.command).append("R").append("\n");

                        break;
                    }

                    queue.add(new Pair(r, pair.command + "R"));
                    visited[r] = true;
                }
            }
        }

        System.out.println(sb);
    }
}

class Pair {
    int num;
    String command;

    public Pair(int num, String command) {
        this.num = num;
        this.command = command;
    }
}