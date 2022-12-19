import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] sang = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sang[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int [] su = new int[m];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i< m; i++) {
            su[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(sang);

        for (int a : su) {
            if (binary(sang, a)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    static boolean binary(int [] list, int target) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == target) {
                return true;
            } else if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}