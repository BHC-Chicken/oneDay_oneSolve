import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int convertToDays(int month, int day) {
        int totalDays = 0;
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < month; i++) {
            totalDays += daysInMonth[i];
        }

        totalDays += day;

        return totalDays;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Flower> flowerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowerList.add(new Flower(startMonth, startDay, endMonth, endDay));
        }

        flowerList.sort((flower1, flower2) -> {
            if (flower1.startDay != flower2.startDay) {
                return Integer.compare(flower1.startDay, flower2.startDay);
            }

            return Integer.compare(flower2.endDay, flower1.endDay);
        });

        int comeBlossom = convertToDays(3,1);
        int endBlossom = convertToDays(12,1);

        int count = 0;
        int currentEnd = comeBlossom;
        int flowerIndex = 0;

        while (currentEnd < endBlossom) {
            int maxEnd = 0;

            while (flowerIndex < n && flowerList.get(flowerIndex).startDay <= currentEnd) {
                maxEnd = Math.max(maxEnd, flowerList.get(flowerIndex).endDay);

                flowerIndex++;
            }

            if (maxEnd == 0 || maxEnd <= currentEnd) {
                count = 0;

                break;
            }

            count++;
            currentEnd = maxEnd;
        }

        System.out.println(count);
    }

    static class Flower {
        int startDay;
        int endDay;

        public Flower(int startMonty, int startDay, int endMonth, int endDay) {
            this.startDay = convertToDays(startMonty, startDay);
            this.endDay = convertToDays(endMonth, endDay);
        }
    }
}
