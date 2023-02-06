import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < test_case; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arrayList = new ArrayList<>(set);

        Collections.sort(arrayList);

        for (Integer integer : arrayList) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }
}