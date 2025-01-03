import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int maxRow = -1;
        int maxCol = -1;


        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] numbers = br.readLine().split(" ");

            int dir = Integer.parseInt(numbers[0]);
            int length = Integer.parseInt(numbers[1]);

            list.add(numbers[1]);
            if (dir == 1 || dir == 2) {
                maxRow = Math.max(maxRow, length);
            } else {
                maxCol = Math.max(maxCol, length);
            }
        }

        int maxRowIndex = list.indexOf(maxRow + "");
        int maxColIndex = list.indexOf(maxCol + "");

        int prevRow = maxRowIndex == 0 ? 5 : maxRowIndex - 1;
        int nextRow = maxRowIndex == 5 ? 0 : maxRowIndex + 1;

        int prevCol = maxColIndex == 0 ? 5 : maxColIndex - 1;
        int nextCol = maxColIndex == 5 ? 0 : maxColIndex + 1;

        int minusRow = Math.abs(Integer.parseInt(list.get(prevRow)) - Integer.parseInt(list.get(nextRow)));
        int minusCol = Math.abs(Integer.parseInt(list.get(prevCol)) - Integer.parseInt(list.get(nextCol)));

        int cal = maxRow * maxCol - (minusRow * minusCol);

        System.out.println(cal * n);
    }
}
