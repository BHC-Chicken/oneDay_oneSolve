import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int loop = Integer.parseInt(br.readLine());
        int sum = 0;

        while (loop-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                sum += num;
                stack.push(num);
            } else {
                sum -= stack.pop();
            }
        }

        System.out.println(sum);
    }
}