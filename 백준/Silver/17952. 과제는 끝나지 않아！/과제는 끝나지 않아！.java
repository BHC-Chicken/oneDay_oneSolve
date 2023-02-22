import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Work> score = new Stack<>();
        Queue<Work> queue = new LinkedList<>();

        int loop = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer st;

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    queue.add(new Work(0,0));
                } else {
                    queue.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                }
            }
        }

        Work work = queue.poll();
        work.time -= 1;

        for (int i = 0; i < loop - 1; i++) {
            if (queue.peek().score != 0) {
                score.push(work);
                work = queue.poll();
            } else {
                queue.poll();
            }
            work.time -= 1;

            if (work.time == 0) {
                result += work.score;
                if (!score.isEmpty()) {
                    work = score.pop();
                }
            }
        }
        System.out.println(result);
    }
}

class Work {
    int score;
    int time;

    public Work(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

