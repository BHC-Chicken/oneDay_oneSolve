import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        int [] arr = new int[10];
        int sum = 0;

        if (!num.contains("0")) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < num.length(); i++) {
            int value = Character.getNumericValue(num.charAt(i));
            arr[value]++;
            sum += value;
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            while (arr[i] > 0) {
                sb.append(i);
                arr[i]--;
            }
        }

        System.out.println(sb);
    }
}