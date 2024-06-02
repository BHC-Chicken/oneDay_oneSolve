import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int size;
    static int result;
    static int[] arr;

    static boolean queenRangeIn(int num) {
        for (int i = 0; i < num; i++) {
            if (arr[num] == arr[i]) {

                return false;
            } else if (Math.abs(num - i) == Math.abs(arr[num] - arr[i])) {

                return false;
            }
        }

        return true;
    }

    static void back(int num) {
        if (num == size) {
            result++;

            return;
        }

        for (int i = 0; i < size; i++) {
            arr[num] = i;

            if (queenRangeIn(num)) {
                back(num + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new int[size];

        back(0);

        System.out.println(result);
    }
}
