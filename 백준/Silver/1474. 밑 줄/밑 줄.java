import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] capital = new int[n];

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            list.add(word);
            m -= word.length();

            if (word.charAt(0) - 'a' >= 0) {
                capital[i] = 1;
            } else {
                capital[i] = 2;
            }
        }

        int div = m / (n - 1);
        int rest = m - (div * (n - 1));

        for (int i = 0; i < list.size() - 1; i++) {

            list.set(i, list.get(i) + "_".repeat(div));
        }

        if (rest > 0) {
            for (int i = 1; i < n; i++) {
                if (capital[i] == 1) {
                    list.set(i - 1, list.get(i - 1) + "_");
                    rest--;
                }

                if (rest == 0) {
                    break;
                }
            }
        }

        if (rest > 0) {
            for (int i = n - 1; i >= 1; i--) {
                if (capital[i] == 2) {
                    list.set(i - 1, list.get(i - 1) + "_");
                    rest--;
                }

                if (rest == 0) {
                    break;
                }
            }
        }

        for (String s : list) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}