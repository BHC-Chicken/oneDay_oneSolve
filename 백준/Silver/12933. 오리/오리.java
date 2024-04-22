import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        boolean[] arr = new boolean[word.length()];
        int result = 0;
        int index = 0;

        char[] s = {'q', 'u', 'a', 'c', 'k'};

        if (word.length() % 5 != 0 || word.charAt(0) != 'q') {
            System.out.println(-1);

            return;
        }

        for (int i = 0; i < word.length(); i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < word.length(); j++) {
                if (!arr[j] && word.charAt(j) == s[index]) {
                    arr[j] = true;
                    index++;
                    list.add(word.charAt(j));
                    if (index == 5) {
                        index = 0;
                    }
                }
            }

            if (!list.isEmpty()) {
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);

                    return;
                }

                result++;
            }
        }

        System.out.println(result);
    }
}
