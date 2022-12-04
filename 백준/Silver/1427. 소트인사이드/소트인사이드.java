import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Character> arrayList = new ArrayList<>();

        String num = br.readLine();
        for (int i =0; i < num.length(); i++) {
            arrayList.add(num.charAt(i));
        }

        arrayList.sort(Comparator.reverseOrder());

        for (int i =0; i < num.length(); i++) {
            bw.write(arrayList.get(i));
        }

        bw.flush();
    }
}