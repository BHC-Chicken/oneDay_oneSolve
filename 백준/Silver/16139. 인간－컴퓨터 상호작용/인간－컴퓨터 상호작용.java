import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<int[]> list = new ArrayList<>();

        String word = br.readLine();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) {
            list.add(new int[200001]);
            int[] arr = list.get(i);
            arr[0] = 0;
        }

        for (int i = 1; i <= word.length(); i++) {
            int c = word.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                int[] arr = list.get(j);

                if (j == c) {
                    arr[i] = arr[i - 1] + 1;
                } else {
                    arr[i] = arr[i - 1];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            int[] arr = list.get(s);
            int result = arr[end] - arr[start - 1];

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
