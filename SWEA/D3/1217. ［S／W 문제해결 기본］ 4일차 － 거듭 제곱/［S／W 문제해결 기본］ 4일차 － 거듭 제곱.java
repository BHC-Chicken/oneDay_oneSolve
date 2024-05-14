import java.util.Scanner;

public class Solution {
    static int result;
    static int a;
    static int b;

    static void mul(int count) {
        if (count == b) {

            return;
        }

        result *= a;
        mul(count + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int tc = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();

            result = 1;
            mul(0);
            System.out.println("#" + i + " " + result);
        }
    }
}
