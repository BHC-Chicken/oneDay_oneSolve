import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            int num = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (s.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if (map.size() == 0) {
                        continue;
                    }

                    int temp = value == 1 ? map.lastKey() : map.firstKey();
                    if (map.put(temp, map.get(temp) - 1) == 1) {
                        map.remove(temp);
                    }
                }
            }

            System.out.println(map.size() == 0 ? "EMPTY" : map.lastKey() + " " + map.firstKey());
        }
    }
}