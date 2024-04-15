import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ascCount;
    static int descCount;
    static int junSeed;
    static int sungSeed;
    static int junCount;
    static int sungCount;
    static int prev;

    static void jun(int money) {
        if (junSeed >= money) {

            junCount += (junSeed / money);
            junSeed -= (junSeed / money) * money;
        }
    }

    static void sung(int money) {
        if (prev < money) {
            ascCount++;
            descCount = 0;
        } else if (prev > money) {
            descCount++;
            ascCount = 0;
        } else {
            descCount = 0;
            ascCount = 0;
        }

        if (descCount >= 3) {
            if (sungSeed >= money) {

                sungCount += (sungSeed / money);
                sungSeed -= (sungSeed / money) * money;
            }
        }

        if (ascCount >= 3) {
            sungSeed += (money * sungCount);
            sungCount = 0;
        }

        prev = money;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int today = 0;

        junSeed = num;
        sungSeed = num;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            today = Integer.parseInt(st.nextToken());

            jun(today);
            sung(today);
        }

        junSeed += (junCount * today);
        sungSeed += (sungCount * today);

        if (junSeed > sungSeed) {
            System.out.println("BNP");
        } else if (junSeed < sungSeed) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
