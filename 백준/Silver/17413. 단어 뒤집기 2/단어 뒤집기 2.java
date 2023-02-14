import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), "<", true);
        ArrayList<String> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            StringTokenizer special = new StringTokenizer(st.nextToken(), ">", true);
            while (special.hasMoreTokens()) {
                StringTokenizer space = new StringTokenizer(special.nextToken(), " ", true);
                while (space.hasMoreTokens()) {
                    list.add(space.nextToken());
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("<")) {
                result.append(list.get(i));
                i++;
                while (!list.get(i).equals(">")) {
                    result.append(list.get(i));
                    i++;
                }
                result.append(">");
            } else {
                StringBuilder temp = new StringBuilder(list.get(i));
                result.append(temp.reverse());
            }
        }

        System.out.println(result);
    }
}