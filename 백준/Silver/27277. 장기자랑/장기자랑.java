import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        while (list.size() >= 2) {
            int max = list.remove(list.size() - 1);
            int min = list.remove(0);

            result += Math.max(max - min, 0);

            if (list.isEmpty()) {
                result += min;
            }
        }

        if (!list.isEmpty()) {
            result += list.remove(0);
        }

        System.out.println(result);
    }
}