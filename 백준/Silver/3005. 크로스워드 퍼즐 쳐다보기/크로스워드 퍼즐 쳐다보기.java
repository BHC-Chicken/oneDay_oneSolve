import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[][] arr = new String[r][c];
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String word = br.readLine();
            String[] wordArr = word.split("");
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < c; j++) {
                arr[i][j] = wordArr[j];

                if (!wordArr[j].equals("#")) {
                    temp.append(wordArr[j]);
                } else {
                    if (temp.length() >= 2) {
                        list.add(temp.toString());
                    }

                    temp.setLength(0);
                }
            }

            if (temp.length() >= 2) {
                list.add(temp.toString());
            }
        }

        for (int i = 0; i < c; i++) {
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < r; j++) {
                String s = arr[j][i];

                if (!s.equals("#")) {
                    temp.append(s);
                } else {
                    if (temp.length() >= 2) {
                        list.add(temp.toString());
                    }

                    temp.setLength(0);
                }
            }

            if (temp.length() >= 2) {
                list.add(temp.toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
