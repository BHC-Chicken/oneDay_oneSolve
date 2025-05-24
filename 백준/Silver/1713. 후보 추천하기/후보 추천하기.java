import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    static int minNum() {
        int count = Integer.MAX_VALUE;
        int index = 0;

        for (int i : map.keySet()) {
            int mapCount = map.get(i);

            if (mapCount < count) {
                count = mapCount;
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int people = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < people; i++) {
            int studentNum = Integer.parseInt(st.nextToken());

            if (map.containsKey(studentNum)) {
                map.merge(studentNum, 1, Integer::sum);
            } else {
                if (map.size() >= n) {
                    int index = minNum();
                    map.remove(index);
                    map.put(studentNum, 1);
                } else {
                    map.put(studentNum, 1);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        StringBuilder result = new StringBuilder();

        for (int i : list) {
            result.append(i).append(" ");
        }

        System.out.println(result);
    }
}

class Pair {
    int num;
    int date;

    public Pair(int num, int date) {
        this.num = num;
        this.date = date;
    }
}
