import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int min;
    static int twoDMin;
    static int threeDMin;

    static void getMidD() {
        int getA = getA();
        int getB = getB();
        int getC = getC();

        if (arr[0] >= arr[5]) {
            threeDMin = Math.min(threeDMin, getA + arr[5]);
        } else {
            threeDMin = Math.min(threeDMin, getA + arr[0]);
        }

        if (arr[1] >= arr[4]) {
            threeDMin = Math.min(threeDMin, getB + arr[4]);
        } else {
            threeDMin = Math.min(threeDMin, getB + arr[1]);
        }

        if (arr[2] >= arr[3]) {
            threeDMin = Math.min(threeDMin, getC + arr[3]);
        } else {
            threeDMin = Math.min(threeDMin, getC + arr[2]);
        }

        twoDMin = Math.min(getA, Math.min(getB, getC));
    }

    static int getA() {
        int d1 = arr[1] + arr[2];
        int d2 = arr[1] + arr[3];
        int d3 = arr[2] + arr[4];
        int d4 = arr[3] + arr[4];

        return Math.min(d1, Math.min(d2, Math.min(d3, d4)));
    }

    static int getB() {
        int d1 = arr[0] + arr[2];
        int d2 = arr[0] + arr[3];
        int d3 = arr[2] + arr[5];
        int d4 = arr[3] + arr[5];

        return Math.min(d1, Math.min(d2, Math.min(d3, d4)));
    }

    static int getC() {
        int d1 = arr[0] + arr[1];
        int d2 = arr[0] + arr[4];
        int d3 = arr[1] + arr[5];
        int d4 = arr[4] + arr[5];

        return Math.min(d1, Math.min(d2, Math.min(d3, d4)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        twoDMin = Integer.MAX_VALUE;
        threeDMin = Integer.MAX_VALUE;

        long sum = 0;
        int index = -1;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[6];

        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            min = Math.min(min, num);
            if (num > max) {
                max = num;
                index = i;
            }
        }

        if (n == 1L) {
            for (int i = 0; i < 6; i++) {
                if (i == index) {
                    continue;
                }

                sum += arr[i];
            }

            System.out.println(sum);

            return;
        }



        getMidD();
        long height = (n - 1) * 4;
        long width = (n - 2) * 4;
        long top = (n * n) - 4 - width;
        long side = (n * n) - ((n - 1) * 2) - n;

        sum += (4L * threeDMin);
        sum += (height * twoDMin);
        sum += (width * twoDMin);
        sum += top * min;
        sum += side * 4 * min;

        System.out.println(sum);
    }
}
