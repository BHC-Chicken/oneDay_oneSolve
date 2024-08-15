import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int h;
    static int k;
    static int size;
    static int[] node;
    static ArrayList<Integer>[] nodeList;

    static void recursion(int s, int e, int depth) {
        if (s > e) {
            return;
        }

        int mid = (s + e) / 2;
        nodeList[depth].add(node[mid]);

        recursion(s, mid - 1, depth + 1);
        recursion(mid + 1, e, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, k) - 1;
        node = new int[size];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }

        h = (int) Math.ceil(Math.log(size) / Math.log(2)) + 1;
        nodeList = new ArrayList[h];

        for (int i = 0; i < h; i++) {
            nodeList[i] = new ArrayList<>();
        }

        recursion(0, size - 1, 0);

        for (int i = 0; i < h; i++) {
            for (int node : nodeList[i]) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

