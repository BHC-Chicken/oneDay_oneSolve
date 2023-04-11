import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] numbers;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int num, int depth) {
        if (depth == n) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + numbers[depth], depth + 1);
                        break;
                    case 1:
                        dfs(num - numbers[depth], depth + 1);
                        break;
                    case 2:
                        dfs(num * numbers[depth], depth + 1);
                        break;
                    case 3:
                        dfs(num / numbers[depth], depth + 1);
                }

                operator[i]++;
            }
        }
    }
}