import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        int value = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;

        Arrays.parallelSort(arr);

        while (start < end) {
            sum = arr[start] + arr[end];

            if (sum == value) {
                count++;
            }
            if (sum >= value) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(count);

    }

}