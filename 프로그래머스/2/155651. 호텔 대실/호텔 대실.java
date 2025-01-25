import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int addMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(2, 4));

        minutes += 9;

        if (minutes >= 60) {
            hours += 1;
            minutes -= 60;
        }

        return hours * 100 + minutes;
    }
    
    public int solution(String[][] book_time) {
        int answer = -1;

        ArrayList<Pair> list = new ArrayList<>();

        for (String[] times : book_time) {
            for (int i = 0; i < times.length; i++) {
                String time = times[i].replace(":", "");
                if (i == 0) {
                    list.add(new Pair(Integer.parseInt(time), 1));
                } else {
                    list.add(new Pair(addMinutes(time), -1));
                }
            }
        }

        Collections.sort(list);

        int sum = 0;

        for (Pair pair : list) {
            sum += pair.value;

            answer = Math.max(sum, answer);
        }

        return answer;
    }
}

class Pair implements Comparable<Pair> {
    int time;
    int value;

    public Pair(int time, int value) {
        this.time = time;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.time == o.time) {
            return o.value - this.value;
        }

        return Integer.compare(this.time, o.time);
    }
}