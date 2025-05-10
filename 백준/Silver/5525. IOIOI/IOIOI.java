import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int result = 0;

        for (int i = 0; i < m; i++) {
            if (word.charAt(i) == 'I') {
                int temp = i;
                int count = 0;

                while (temp + 2 < m) {
                    if (word.charAt(temp + 1) == 'O' && word.charAt(temp + 2) == 'I') {
                        count++;
                        temp += 2;

                        if (count == n) {
                            count --;
                            result++;
                        }
                    } else {
                        break;
                    }
                }

                i = temp;
            }
        }

        System.out.println(result);
    }
}
