import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        ArrayList<People> people = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("O")) {
                    sum += score[j];
                }
            }
            people.add(new People(num, sum));
        }
        Comparator<People> reverse = Comparator.comparing(People::getScore).reversed().thenComparing(People::getNum);
        people.sort(reverse);

        System.out.println(people.get(0).num + " " + people.get(0).score);
    }
}

class People {
    int num;
    int score;

    public People(int num, int score) {
        this.num = num;
        this.score = score;
    }

    public int getNum() {
        return num;
    }

    public int getScore() {
        return score;
    }
}