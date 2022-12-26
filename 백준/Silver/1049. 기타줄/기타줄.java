import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cut = Integer.parseInt(st.nextToken());
        int brand = Integer.parseInt(st.nextToken());
        int minSix = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;
        int mount = 0;

        for (int i = 0; i < brand; i++) {
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            if (minSix > six) {
                minSix = six;
            }

            if (minOne > one) {
                minOne = one;
            }
        }

        if (cut <= 6) {
            mount = Math.min(minSix, minOne * cut);
        } else {
            int div = cut / 6;
            mount += div * Math.min(minSix, minOne * 6);
            cut -= div * 6;
            mount += Math.min(minSix, minOne * cut);

        }

        System.out.println(mount);

    }
}