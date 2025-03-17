import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int c;
    static int[] alpha = new int[26];
    static boolean[] visited = new boolean[26];
    static StringBuilder sb = new StringBuilder();

    static boolean isVowel(int i) {
        return i == 0 || i == 4 || i == 8 || i == 14 || i == 20;
    }

    static void backTracking(int nowLength, StringBuilder nowWord, int vowelCount, int conCount, int index) {
        if (nowLength == l) {
            if (vowelCount >= 1 && conCount >= 2) {
                sb.append(nowWord).append("\n");
            }

            return;
        }

        for (int i = index; i < alpha.length; i++) {
            if (!visited[i] && alpha[i] != 0) {
                visited[i] = true;
                nowWord.append((char) (i + 'a'));

                boolean flag = isVowel(i);

                if (flag) {
                    backTracking(nowLength + 1, nowWord, vowelCount + 1, conCount, i + 1);
                } else {
                    backTracking(nowLength + 1, nowWord, vowelCount, conCount + 1, i + 1);
                }
                nowWord.deleteCharAt(nowWord.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {
            char word = st.nextToken().charAt(0);
            alpha[word - 'a'] = 1;
        }

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) {
                visited[i] = true;
                StringBuilder now = new StringBuilder();
                if (isVowel(i)) {
                    backTracking(1, now.append((char) (i + 'a')), 1, i, 0 + 1);
                } else {
                    backTracking(1, now.append((char) (i + 'a')), 0, 1, i + 1);
                }
            }
        }

        System.out.println(sb);
    }
}
