import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static boolean[] arr = new boolean[(123456) * 2 + 1];
    public static int[] prime = new int[(123456) * 2 + 1];

    static void get_prime() {
        arr[0] = arr[1] = true;

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }

    static void get_count() {
        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                count++;
            }
            prime[i] = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();
        get_count();

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            sb.append(prime[2*num] - prime[num]).append("\n");
        }
        System.out.println(sb);
    }
}

