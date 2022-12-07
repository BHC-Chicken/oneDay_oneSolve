import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sNum = br.readLine();
        double num = Double.parseDouble(sNum);

        for (int i = 1; i < sNum.length(); i++) {
            double div = Math.pow(10, i);
            num = (int) (Math.round((num / div)) * div);
        }

        System.out.println((int) num);

    }
}