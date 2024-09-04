import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<Tuple> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int index = 1;

        for (int i = 0; i < a; i++) {
            map.put(index++, 2);
        }

        for (int i = 0; i < b; i++) {
            map.put(index++, 2);
        }

        for (int i = 0; i < c; i++) {
            map.put(index++, 2);
        }

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());

            int power = Integer.parseInt(st.nextToken());
            int motor = Integer.parseInt(st.nextToken());
            int cable = Integer.parseInt(st.nextToken());
            int isBroken = Integer.parseInt(st.nextToken());

            if (isBroken == 1) {
                map.put(power, 1);
                map.put(motor, 1);
                map.put(cable, 1);
            } else {
                list.add(new Tuple(power, motor, cable, isBroken));
            }
        }

        for (Tuple t : list) {
            if (map.get(t.a) == 1) {
                if (map.get(t.b) == 1) {
                    map.put(t.c, 0);
                }
                if (map.get(t.c) == 1) {
                    map.put(t.b, 0);
                }
            } else if (map.get(t.b) == 1) {
                if (map.get(t.c) == 1) {
                    map.put(t.a, 0);
                }
            }
        }

        for (int i = 1; i < index; i++) {
            sb.append(map.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}

class Tuple {
    int a;
    int b;
    int c;
    int isBroken;

    public Tuple(int a, int b, int c, int isBroken) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.isBroken = isBroken;
    }
}
