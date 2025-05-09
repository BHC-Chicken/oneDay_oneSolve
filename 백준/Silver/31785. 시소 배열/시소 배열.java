import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Pair> list = new ArrayList<>();

    static void reSort(ArrayList<Pair> half) {
        ArrayList<Pair> newList = new ArrayList<>();
        newList.add(new Pair(0, 0));

        for (int i = 0; i < half.size(); i++) {
            Pair pair = half.get(i);
            int prefixSum = pair.ordinary + newList.get(i).prefixSum;

            newList.add(new Pair(pair.ordinary, prefixSum));
        }

        list = newList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        list.add(new Pair(0, 0));

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int num = Integer.parseInt(st.nextToken());
                Pair pair = list.get(list.size() - 1);
                list.add(new Pair(num, pair.prefixSum + num));
            } else {
                int mid = (list.size() - 1) / 2;

                int front = list.get(mid).prefixSum;
                int back = list.get(list.size() - 1).prefixSum - front;

                if (front <= back) {
                    result.append(front).append("\n");
                    reSort(new ArrayList<>(list.subList(mid + 1, list.size())));
                } else {
                    result.append(back).append("\n");
                    list = new ArrayList<>(list.subList(0, mid + 1));
                }
            }
        }

        for (int i = 1; i < list.size(); i++) {
            result.append(list.get(i).ordinary).append(" ");
        }

        System.out.println(result);
    }
}

class Pair {
    int ordinary;
    int prefixSum;

    public Pair(int ordinary, int prefixSum) {
        this.ordinary = ordinary;
        this.prefixSum = prefixSum;
    }
}