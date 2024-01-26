import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int loop = Integer.parseInt(br.readLine());
        String formula = br.readLine();
        double[] arr = new double[loop];

        for (int i = 0; i < loop; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) >= 'A' && formula.charAt(i) <= 'Z') {
                stack.push(arr[formula.charAt(i) - 'A']);
            } else if (formula.charAt(i) == '+') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num2 + num1);
            } else if (formula.charAt(i) == '-') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num2 - num1);
            } else if (formula.charAt(i) == '*') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num2 * num1);
            } else if (formula.charAt(i) == '/') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num2 / num1);
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}