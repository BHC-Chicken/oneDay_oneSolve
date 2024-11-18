import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int result = 0;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'A';

            if (arr1[index] == 0) {
                arr1[index] = i + 1;
            } else {
                arr2[index] = i + 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (arr1[i] < arr1[j] && arr1[j] < arr2[i] && arr2[i] < arr2[j]) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
