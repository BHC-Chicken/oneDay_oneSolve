import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int length = Integer.parseInt(input[1]);
        int weight = Integer.parseInt(input[2]);

        int[] trucks = new int[n];
        input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(input[i]);
        }

        Queue<Integer> bridge = new LinkedList<>();
        int currentWeight = 0;
        int time = 0;
        int index = 0;

        for (int i = 0; i < length; i++) {
            bridge.add(0);
        }

        while (index < n) {
            time++;

            currentWeight -= bridge.poll();

            if (bridge.size() == length) {
                currentWeight -= bridge.poll();
            }

            if (currentWeight + trucks[index] <= weight) {
                bridge.add(trucks[index]);
                currentWeight += trucks[index];
                index++;
            } else {
                bridge.add(0);
            }
        }

        time += length;

        System.out.println(time);
    }
}