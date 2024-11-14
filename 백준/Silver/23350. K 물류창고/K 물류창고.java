import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] priority = new int[m + 1];
        Queue<Pair> queue = new LinkedList<>();
        Stack<Pair> temp = new Stack<>();
        Stack<Pair> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            int p = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);

            priority[p]++;
            queue.add(new Pair(p, w));
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (stack.isEmpty()) {
                if (pair.priority == m) {
                    stack.add(pair);
                    priority[m]--;
                } else {
                    queue.add(pair);
                }
                result += pair.weight;
            } else {
                if (pair.priority == m) {
                    if (stack.peek().weight > pair.weight && stack.peek().priority == m) {
                        stack.add(pair);
                        result += pair.weight;
                    } else {
                        while (!stack.isEmpty() && stack.peek().weight < pair.weight && stack.peek().priority == m) {
                            Pair tempPair = stack.pop();
                            result += tempPair.weight;
                            temp.add(tempPair);
                        }

                        stack.add(pair);
                        result += pair.weight;

                        while (!temp.isEmpty()) {
                            Pair tempPair = temp.pop();
                            result += tempPair.weight;
                            stack.add(tempPair);
                        }
                    }
                    priority[m]--;
                } else {
                    queue.add(pair);
                    result += pair.weight;
                }
            }

            if (priority[m] == 0) {
                m -= 1;
            }
        }

        System.out.println(result);
    }
}

class Pair {
    int priority;
    int weight;

    public Pair(int priority, int weight) {
        this.priority = priority;
        this.weight = weight;
    }
}
