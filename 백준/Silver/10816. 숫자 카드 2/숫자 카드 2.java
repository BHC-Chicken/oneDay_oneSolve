import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(number)) {
                hashMap.put(number, 1);
            } else {
                int value = hashMap.get(number) + 1;
                hashMap.put(number, value);
            }
        }

        int loop = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < loop; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (hashMap.get(number) == null) {
                result.append(0).append(" ");
            } else {
                result.append(hashMap.get(number)).append(" ");
            }
        }
        System.out.println(result);
    }
}