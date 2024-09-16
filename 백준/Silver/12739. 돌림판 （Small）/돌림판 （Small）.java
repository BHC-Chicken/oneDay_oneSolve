import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int BCount = 0;
    static int RCount = 0;
    static int GCount = 0;

    static void colorCount(String p) {
        switch (p) {
            case "B":
                BCount++;
                break;
            case "R":
                RCount++;
                break;
            case "G":
                GCount++;
                break;
        }

    }

    static String diff(String pMinus, String p, String pPlus) {
        if ((!pMinus.equals(p) && !p.equals(pPlus) && !pPlus.equals(pMinus)) || (pMinus.equals(p) && p.equals(pPlus))) {
            return "B";
        } else {
            BCount = 0;
            RCount = 0;
            GCount = 0;

            colorCount(pMinus);
            colorCount(p);
            colorCount(pPlus);

            if ((RCount == 2 && GCount == 1) || (GCount == 2 && BCount == 1) || (BCount == 2 && RCount == 1)) {
                return "R";
            }
        }

        return "G";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] colors = br.readLine().split("");

        for (int i = 0; i < k; i++) {
            String[] tempColors = new String[n];
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    tempColors[j] = diff(colors[n - 1], colors[0], colors[1]);
                } else if (j == (n - 1)) {
                    tempColors[j] = diff(colors[n - 2], colors[n - 1], colors[0]);
                } else {
                    tempColors[j] = diff(colors[j - 1], colors[j], colors[j + 1]);
                }
            }

            colors = tempColors;
        }

        BCount = 0;
        RCount = 0;
        GCount = 0;

        for (int i = 0; i < n; i++) {
            colorCount(colors[i]);
        }

        System.out.println(RCount + " " + GCount + " " + BCount);
    }
}
