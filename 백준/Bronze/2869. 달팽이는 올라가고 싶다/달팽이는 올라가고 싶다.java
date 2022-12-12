import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int high = Integer.parseInt(st.nextToken());
        int div = 0;
        int na = 0;

        if (up >= high) {
            System.out.println(1);
            return;
        }

        high -= up;
        up -= down;
        div = high / up;
        na = high % up;
        if (na > 0) {
            System.out.println(div + 2);
        } else {
            System.out.println(na + div + 1);
        }
    }

}