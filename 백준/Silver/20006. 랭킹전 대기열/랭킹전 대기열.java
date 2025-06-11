import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int p;
    static int m;
    static String[] arr = new String[301];
    static TreeMap<Integer, ArrayList<Tuple>> treeMap = new TreeMap<>();

    static void newNode(int level, String name, int index) {
        if (m == 1) {
            arr[index] = "Started!" + "\n" + level + " " + name + "\n";

            return;
        }

        ArrayList<Tuple> newList = new ArrayList<>();
        newList.add(new Tuple(level, index, name));

        treeMap.put(level, newList);
    }

    static void addNode(int level, String name, int num) {
        ArrayList<Tuple> list = treeMap.get(num);
        list.add(new Tuple(level, list.get(0).index, name));

        if (list.size() >= m) {
            StringBuilder sb = new StringBuilder();

            sb.append("Started!").append("\n");
            list.sort((o1, o2) -> o1.name.compareTo(o2.name));

            for (Tuple tuple : list) {
                sb.append(tuple.level).append(" ").append(tuple.name).append("\n");
            }

            treeMap.remove(num);

            arr[list.get(0).index] = sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 1;
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (treeMap.isEmpty()) {
                newNode(level, name, index++);

                continue;
            }

            Integer floor = treeMap.floorKey(level);
            Integer ceil = treeMap.ceilingKey(level);

            if (floor != null && ceil != null && level - floor <= 10 && ceil - level <= 10) {
                ArrayList<Tuple> floorList = treeMap.get(floor);
                ArrayList<Tuple> ceilList = treeMap.get(ceil);

                if (floorList.get(0).index < ceilList.get(0).index) {
                    addNode(level, name, floor);
                } else {
                    addNode(level, name, ceil);
                }

                continue;
            }

            if (floor != null && level - floor <= 10) {
                addNode(level, name, floor);
            } else if (ceil != null && ceil - level <= 10) {
                addNode(level, name, ceil);
            } else {
                newNode(level, name, index++);
            }
        }

        if (!treeMap.isEmpty()) {
            for (ArrayList<Tuple> pairList : treeMap.values()) {
                StringBuilder sb = new StringBuilder();

                sb.append("Waiting!").append("\n");
                pairList.sort((o1, o2) -> o1.name.compareTo(o2.name));
                for (Tuple tuple : pairList) {
                    sb.append(tuple.level).append(" ").append(tuple.name).append("\n");
                }

                arr[pairList.get(0).index] = sb.toString();
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= 300; i++) {
            if (arr[i] != null) {
                result.append(arr[i]);
            }
        }

        System.out.println(result);
    }
}

class Tuple {
    int level;
    int index;
    String name;

    public Tuple(int level, int index, String name) {
        this.level = level;
        this.index = index;
        this.name = name;
    }
}
