import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Checker> list = new ArrayList<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list.add(new Checker(x, r));
        }

        list.sort((r1, r2) -> r1.left - r2.left);

        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i).left <= list.get(i + 1).left) &&
                    (list.get(i).right >= list.get(i + 1).left) &&
                    (list.get(i).right <= list.get(i + 1).right)) {

                System.out.println("NO");

                return;
            }
        }

        System.out.println("YES");
    }
}

class Checker {
    int left;
    int right;

    public Checker(int x, int r) {
        this.left = x - r;
        this.right = x + r;
    }

}