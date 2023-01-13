import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Integer> number = new LinkedList<>();
            Queue<Boolean> bool = new LinkedList<>();
            int count = 1;
            int result = 0;

            int paper = Integer.parseInt(st.nextToken());
            int important = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < paper; j++) {
                int num = Integer.parseInt(st.nextToken());
                number.add(num);
                list.add(num);

                if (j == important) {
                    result = num;
                    bool.add(true);
                } else {
                    bool.add(false);
                }
            }

            list.sort(Comparator.reverseOrder());

            while (true) {
                boolean pollBool = bool.poll();
                int pollNum = number.poll();

                if (pollNum != list.get(0)) {
                    bool.add(pollBool);
                    number.add(pollNum);
                } else {
                    list.remove(0);
                    if (pollNum == result && pollBool) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                }
            }
        }
    }
}