import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int index = sb.length();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            switch (cmd) {
                case "L":
                    if (index != 0) {
                        index -= 1;
                    }
                    break;
                case "D":
                    if (index < sb.length()) {
                        index += 1;
                    }
                    break;
                case "B":
                    if (index != 0) {
                        if (index == sb.length()) {
                            sb.deleteCharAt(index - 1);
                            index = sb.length();
                        } else {
                            sb.deleteCharAt(index - 1);
                            index -= 1;
                        }
                    }
                    break;
                case "P":
                    String word = input[1];

                    if (index == sb.length()) {
                        sb.append(word);
                        index = sb.length();
                    } else {
                        sb.insert(index, word);
                        index += 1;
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
