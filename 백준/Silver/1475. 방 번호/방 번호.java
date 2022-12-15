import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] result = new int[10];
        int max = 0;

        for (int a = 0; a < num.length(); a++) {
            int c = Character.getNumericValue(num.charAt(a));
            if (c == 6 || c == 9) {
                if (result[6] > result[9]) {
                    c = 9;
                } else {
                    c = 6;
                }
            }
            int temp = ++result[c];

            if (max < temp) {
                max = temp;
            }
        }

        System.out.println(max);
    }
}
