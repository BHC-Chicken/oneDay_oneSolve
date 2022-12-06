import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder first = new StringBuilder(st.nextToken());
        StringBuilder second = new StringBuilder(st.nextToken());

        String num1 = first.reverse().toString();
        String num2 = second.reverse().toString();
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        StringBuilder sb = new StringBuilder(String.valueOf(result));
        sb.reverse();

        System.out.println(Integer.parseInt(sb.toString()));
    }
}