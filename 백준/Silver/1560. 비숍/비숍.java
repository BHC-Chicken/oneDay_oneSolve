import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger big = new BigInteger(br.readLine());

        if (big.compareTo(BigInteger.ONE) == 0) {
            System.out.println(1);
        } else if (big.compareTo(BigInteger.TWO) == 0) {
            System.out.println(2);
        } else {
            System.out.println(big.add(big.subtract(BigInteger.TWO)));
        }
    }
}
