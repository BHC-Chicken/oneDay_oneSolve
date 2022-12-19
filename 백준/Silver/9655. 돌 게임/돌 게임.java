import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int div = a / 3;
        int mod = a % 3;

        if (div % 2 == 0) {
            if (mod == 1) {
                System.out.println("SK");
            } else {
                System.out.println("CY");
            }
            return;
        }

        if (mod == 1){
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}