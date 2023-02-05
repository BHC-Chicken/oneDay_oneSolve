import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int son = a * d + b * c;
        int mom = b * d;

        int numGcd = gcd(son, mom);

        System.out.println(son/numGcd + " " + mom/numGcd);
    }

    public static int gcd(int a, int b) {
        int temp = a % b;
        if (temp == 0) {
            return b;
        } else {
            return gcd(b, temp);
        }
    }
}