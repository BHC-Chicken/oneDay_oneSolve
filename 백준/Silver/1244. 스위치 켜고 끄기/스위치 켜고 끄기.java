import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int switchNum;
    static boolean[] switchArr;

    static boolean inRage(int index) {
        return index >= 1 && index <= switchNum;
    }

    static void man(int index) {
        for (int i = index; i <= switchNum; i += index) {
            if (inRage(i)) {
                switchArr[i] = !switchArr[i];
            } else {
                return;
            }
        }
    }

    static void woman(int index) {
        int left = index - 1;
        int right = index + 1;

        switchArr[index] = !switchArr[index];

        while (inRage(left) && inRage(right) && (switchArr[left] == switchArr[right])) {
            switchArr[left] = !switchArr[left];
            switchArr[right] = !switchArr[right];
            left--;
            right++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switchNum = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        switchArr = new boolean[switchNum + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= switchNum; i++) {
            int num = Integer.parseInt(st.nextToken());

            switchArr[i] = num == 1;
        }

        int studentNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                man(index);
            } else {
                woman(index);
            }
        }

        for (int i = 1; i <= switchNum; i++) {
            if (switchArr[i]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
