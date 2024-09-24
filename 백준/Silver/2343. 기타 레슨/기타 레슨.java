import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] video;
    static int maxLength;
    static int totalLength;

    static void binary() {
        while (maxLength < totalLength) {
            int mid = (maxLength + totalLength) / 2;
            if (getCount(mid) > m) {
                maxLength = mid + 1;
            } else {
                totalLength = mid;
            }

        }
    }

    static int getCount(int mid) {
        int count = 1;
        int restMinute = mid;

        for (int i = 0; i < n; i++) {
            if (restMinute < video[i]) {
                restMinute = mid;
                count++;
            }

            restMinute -= video[i];
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        video = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            video[i] = num;

            totalLength += num;
            maxLength = Math.max(maxLength, num);
        }

        binary();
        System.out.println(maxLength);
    }
}