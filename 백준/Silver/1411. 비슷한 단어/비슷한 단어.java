import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static int num;

    static void pattern(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 1;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                map.put(c, index);
                sb.append(index++);
            }
        }
        hashMap.put(sb.toString(), hashMap.getOrDefault(sb.toString(), 0) + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < num; i++) {
            pattern(br.readLine());
        }

        for (int value : hashMap.values()) {
            if (value != 1) {
                result += value * (value - 1) / 2;
            }
        }

        System.out.println(result);
    }
}
