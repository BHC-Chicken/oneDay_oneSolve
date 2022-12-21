import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] arr = {"2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7",
                "77", "777", "7777", "8", "88", "888",
                "9", "99", "999", "9999"};
        int[] num = new int[10];
        num[0] = 0;

        for (int i = 1; i <= 9; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        char c = ' ';

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            char a = arr[index].charAt(0);
            int z = Arrays.stream(num).boxed().collect(Collectors.toList()).indexOf(Character.getNumericValue(a));
            String result = arr[index].replaceAll(String.valueOf(a), String.valueOf(z));

            if (result.charAt(0) == c) {
                sb.append("#");
            }
            sb.append(result);

            c = result.charAt(0);
        }

        System.out.println(sb);
    }
}