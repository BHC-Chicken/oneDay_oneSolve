import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Word> wordList = new ArrayList<>();
        HashSet<String> ex = new HashSet<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            ex.add(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            String[] split = list.get(i).split("\\.");

            if (ex.contains(split[1])) {
                wordList.add(new Word(split[0], split[1], list.get(i), true));
            } else {
                wordList.add(new Word(split[0], split[1], list.get(i), false));
            }
        }

        Collections.sort(wordList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(wordList.get(i).fullName).append("\n");
        }

        System.out.println(result);
    }
}

class Word implements Comparable<Word> {
    String name;
    String extension;
    String fullName;
    boolean contain;

    public Word(String name, String extension,String fullName, boolean contain) {
        this.name = name;
        this.extension = extension;
        this.fullName = fullName;
        this.contain = contain;
    }

    @Override
    public int compareTo(Word o) {
        if (this.name.equals(o.name)) {
            if (this.contain != o.contain) {
                return o.contain ? 1 : -1;
            }
            return this.extension.compareTo(o.extension);
        }
        return this.name.compareTo(o.name);
    }
}
