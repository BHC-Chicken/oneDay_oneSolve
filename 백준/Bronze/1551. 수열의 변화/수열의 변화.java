import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> copy = new ArrayList<>();

        int numbers = Integer.parseInt(firstLine.nextToken());
        int loop = Integer.parseInt(firstLine.nextToken());
        int temp = 0;

        StringTokenizer secondLine = new StringTokenizer(br.readLine(), ",");

        while (secondLine.hasMoreTokens()) {
            original.add(Integer.parseInt(secondLine.nextToken()));
        }

        while (temp < loop) {
            copy.clear();
            for (int a = 0; a < numbers - 1; a++) {
                copy.add(original.get(a + 1) - original.get(a));
            }
            numbers--;
            original.clear();
            for (int a = 0; a < numbers; a++) {
                original.add(copy.get(a));
            }
            temp++;
        }

        for (int i = 0; i < original.size(); i++) {
            System.out.print(original.get(i));
            if (i != original.size() - 1) {
                System.out.print(",");
            }
        }

    }
}