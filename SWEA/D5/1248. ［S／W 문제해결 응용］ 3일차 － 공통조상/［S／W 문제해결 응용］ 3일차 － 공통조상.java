import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int V, E, a, b;
    static int size;
    static Node[] nodes;
    static boolean[] visited;

    static void get(Node node) {
        size++;
        if (node.leftIndex != 0) {
            get(nodes[node.leftIndex]);
        }
        if (node.rightIndex != 0) {
            get(nodes[node.rightIndex]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 1; i <= test_case; i++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            nodes = new Node[V + 1];
            visited = new boolean[V + 1];
            for (int j = 1; j <= V; j++) {
                nodes[j] = new Node(j);
            }

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < E; j++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if (nodes[parent].leftIndex == 0) {
                    nodes[parent].leftIndex = child;
                } else {
                    nodes[parent].rightIndex = child;
                }
                nodes[child].index = parent;
            }

            int start = 1;
            while (true) {
                if (a != 1) {
                    int parent = nodes[a].index;
                    if (visited[parent]) {
                        start = parent;
                        break;
                    }
                    visited[parent] = true;
                    a = parent;
                }
                if (b != 1) {
                    int parent = nodes[b].index;
                    if (visited[parent]) {
                        start = parent;
                        break;
                    }
                    visited[parent] = true;
                    b = parent;
                }
            }
            size = 0;
            get(nodes[start]);
            sb.append("#").append(i).append(" ").append(start).append(" ").append(size).append("\n");
        }

        System.out.println(sb);
    }
}

class Node {
    int data;
    int index;
    int leftIndex;
    int rightIndex;

    public Node(int data) {
        this.data = data;
        this.index = 0;
        this.leftIndex = 0;
        this.rightIndex = 0;
    }
}