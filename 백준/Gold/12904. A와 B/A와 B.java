import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder origin = new StringBuilder(br.readLine());
        StringBuilder goal = new StringBuilder(br.readLine());

        while (origin.length() < goal.length()) {
            if (goal.charAt(goal.length() - 1) == 'A') {
                goal.deleteCharAt(goal.length() - 1);
            } else if (goal.charAt(goal.length() - 1) == 'B') {
                goal.deleteCharAt(goal.length() - 1);
                goal.reverse();
            }
        }
        
        if (origin.toString().contentEquals(goal)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
