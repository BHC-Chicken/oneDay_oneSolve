import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> arr = new HashSet<>();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            arr.add(br.readLine());
        }

        List<String> setArr = new ArrayList<>(List.copyOf(arr));

        setArr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
        });

        for (String s : setArr) {
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
    }
}