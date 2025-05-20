import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static int swap(int s) {
        switch (s) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sampleLength = Integer.parseInt(br.readLine());

        StringBuilder forward = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sampleLength; i++) {
            int num = Integer.parseInt(st.nextToken());

            forward.append(num);
            reverse.insert(0, swap(num));
        }

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < sampleLength; i++) {
            set.add(forward.toString());
            set.add(reverse.toString());

            forward.append(forward.charAt(0));
            reverse.append(reverse.charAt(0));

            forward.deleteCharAt(0);
            reverse.deleteCharAt(0);
        }

        int count = 0;
        StringBuilder result = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());

            StringBuilder compare = new StringBuilder();
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < sampleLength; j++) {
                int num = Integer.parseInt(st.nextToken());

                compare.append(num);
                temp.append(num).append(" ");
            }

            if (set.contains(compare.toString())) {
                count++;
                result.append(temp).append("\n");
            }
        }

        result.insert(0, count + "\n");

        System.out.println(result);
    }
}
