import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set2.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer integer : set2) {
            if (!set1.contains(integer)) {
                count++;
            }
        }

        for (Integer integer : set1) {
            if (!set2.contains(integer)) {
                count++;
            }
        }

        System.out.println(count);
    }
}