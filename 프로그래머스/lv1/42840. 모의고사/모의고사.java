import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] people1 = {1, 2, 3, 4, 5};
        int[] people2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] people3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        People[] people = new People[3];
        List<People> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            people[i] = new People(i + 1);
        }

        for (int collect : answers) {
            if (people1[count1] == collect) {
                people[0].score++;
            }

            if (people2[count2] == collect) {
                people[1].score++;
            }

            if (people3[count3] == collect) {
                people[2].score++;
            }

            count1++;
            count2++;
            count3++;

            if (count1 == people1.length) {
                count1 = 0;
            }
            if (count2 == people2.length) {
                count2 = 0;
            }
            if (count3 == people3.length) {
                count3 = 0;
            }
        }

        Arrays.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.score == o2.score) {
                    return Integer.compare(o1.index, o2.index);
                }
                return o2.score - o1.score;
            }
        });

        list.add(people[0]);

        for (int i = 1; i < 3; i++) {
            if (people[i].score < people[i-1].score) {
                break;
            }
            list.add(people[i]);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).index;
        }
        return answer;
    }
}

class People {
    int index;
    int score;

    public People(int index) {
        this.index = index;
        this.score = 0;
    }
}