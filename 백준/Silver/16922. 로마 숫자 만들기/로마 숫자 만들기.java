//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int result = 0;
//
//        int n = Integer.parseInt(br.readLine());
//
//        ArrayList<Integer> crane = new ArrayList<>();
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            crane.add(Integer.parseInt(st.nextToken()));
//        }
//
//        crane.sort(Comparator.reverseOrder());
//
//        int m = Integer.parseInt(br.readLine());
//
//        PriorityQueue<Integer> baggage = new PriorityQueue<>(Collections.reverseOrder());
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < m; i++) {
//            baggage.add(Integer.parseInt(st.nextToken()));
//        }
//
//        boolean flag = true;
//
//        for (int i = 0; i < ; i++) {
//
//        }
//        while (!baggage.isEmpty() && flag) {
//            int bag = baggage.peek();
//            for (int i = 0; i < n; i++) {
//                if (crane.get(0) < bag) {
//                    flag = false;
//                    break;
//                }
//
//
//            }
//
//            result += 1;
//        }
//
//        if (!baggage.isEmpty()) {
//            System.out.println(-1);
//
//            return;
//        }
//
//        System.out.println(result);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer;
    static boolean[] check = new boolean[1001];
    static int[] numbers = {1, 5, 10, 50};

    static void back(int sum, int index, int n, int depth) {
        if (n == depth) {

            if (!check[sum]) {
                check[sum] = true;
                answer++;
            }

            return;
        }

        for (int i = index; i < 4; i++) {
            back(sum + numbers[i], i, n, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        back(0, 0, n, 0);

        System.out.println(answer);
    }
}