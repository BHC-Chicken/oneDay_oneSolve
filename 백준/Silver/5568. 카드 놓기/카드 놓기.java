import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static String[] arr;
    static int n, k;
    static HashSet<String> hashSet = new HashSet<>();
    static boolean[] v;

    private static void bf(int cnt, String cur) {
        if (cnt == k) {
            hashSet.add(cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true;
            bf(cnt + 1, cur + arr[i]);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        v = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        
        bf(0, "");

        System.out.println(hashSet.size());
    }
}
