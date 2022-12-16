import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Name {

    int age;
    String name;

    public Name(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        ArrayList<Name> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Name name = new Name(Integer.parseInt(st.nextToken()), st.nextToken());
            arrayList.add(name);
        }

        Collections.sort(arrayList, Comparator.comparingInt(Name::getAge));

        for (Name name : arrayList) {
            sb.append(name.age).append(" ").append(name.name).append("\n");
        }

        System.out.println(sb);
    }
}