import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            String group = br.readLine();
            int member = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<>();

            for (int j = 0; j < member; j++) {
                list.add(br.readLine());
            }

            Collections.sort(list);

            hashMap.put(group, list);
        }

        for (int i = 0; i < m; i++) {
            String keyword = br.readLine();
            int num = Integer.parseInt(br.readLine());

            if (num == 1) {
                for (String key : hashMap.keySet()) {
                    ArrayList<String> temp = new ArrayList<>(hashMap.get(key));
                    if (temp.contains(keyword)) {
                        sb.append(key).append("\n");
                        break;
                    }
                }
            } else {
                for (String s : hashMap.keySet()) {
                    if (s.equals(keyword)) {
                        for (String mem : hashMap.get(s)) {
                            sb.append(mem).append("\n");
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
