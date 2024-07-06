import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Pair[] pairs = new Pair[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int[] mount = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < k; i++) {
            mount[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(pairs, (a, b) -> a.mount - b.mount);
        Arrays.sort(mount);

        int jewelIndex = 0;

        for (int i = 0; i < k; i++) {
            while (jewelIndex < n && pairs[jewelIndex].mount <= mount[i]) {
                maxHeap.add(pairs[jewelIndex].value);
                jewelIndex++;
            }

            if (!maxHeap.isEmpty()) {
                result += maxHeap.poll();
            }
        }

        System.out.println(result);
    }
}

class Pair {
    int mount;
    int value;

    public Pair(int mount, int value) {
        this.mount = mount;
        this.value = value;
    }
}