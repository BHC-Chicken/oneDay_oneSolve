import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cow = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < cow; i++) {
            String[] input = br.readLine().split(" ");
            int arrival = Integer.parseInt(input[0]);
            int test = Integer.parseInt(input[1]);

            list.add(new Pair(arrival, test));
        }

        Collections.sort(list);

        Pair pair = list.get(0);

        int result = (pair.arrival + pair.time);

        for (int i = 1; i < cow; i++) {
            pair = list.get(i);

            if (result > pair.arrival) {
                result += pair.time;
            } else {
                result = (pair.arrival + pair.time);
            }
        }

        System.out.println(result);
    }
}

class Pair implements Comparable<Pair> {
    int arrival;
    int time;

    public Pair(int x, int y) {
        this.arrival = x;
        this.time = y;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.arrival, o.arrival);
    }
}