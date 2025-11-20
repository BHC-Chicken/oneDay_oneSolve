import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    static boolean isPrev() {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;

        while (arr[j] >= arr[i - 1]) {
            j--;
        }

        swap(i - 1, j);
        j = arr.length - 1;

        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (isPrev()) {

            for (int num : arr) {
                sb.append(num).append(" ");
            }

            System.out.println(sb);

            return;
        }

        System.out.println(-1);
    }
}
