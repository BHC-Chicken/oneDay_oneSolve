import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Pair> map = new HashMap<>();
        HashMap<String, Integer> sumMap = new HashMap<>();

        for (String s : records) {
            String[] split = s.split(" ");

            String time = split[0];
            String[] splitTime = time.split(":");
            String carNumber = split[1];
            String status = split[2];

            if (status.equals("IN")) {
                Pair p = new Pair();
                p.setStart(LocalTime.of(Integer.parseInt(splitTime[0]), Integer.parseInt(splitTime[1])));

                map.put(carNumber, p);
            } else {
                Pair p = map.get(carNumber);
                p.setEnd(LocalTime.of(Integer.parseInt(splitTime[0]), Integer.parseInt(splitTime[1])));
                sumMap.put(carNumber, sumMap.getOrDefault(carNumber, 0) + p.sumTotal());
                map.remove(carNumber);
            }
        }

        for (String carNumber : map.keySet()) {
            Pair p = map.get(carNumber);
            sumMap.put(carNumber, sumMap.getOrDefault(carNumber, 0) + p.sumEndTotal());
        }

        ArrayList<String> list = new ArrayList<>(sumMap.keySet());
        ArrayList<Integer> totalResult = new ArrayList<>();
        Collections.sort(list);

        for (String carNumber : list) {
            int totalFee = 0;
            int time = sumMap.get(carNumber);

            if (time >= fees[0]) {
                totalFee += fees[1];
                time -= fees[0];
            } else {
                totalFee += fees[1];
                time = 0;
            }

            if (time > 0) {
                totalFee += ((time / fees[2]) * fees[3]);

                if (time % fees[2] > 0) {
                    totalFee += fees[3];
                }
            }

            totalResult.add(totalFee);
        }

        int[] result = new int[totalResult.size()];

        for (int i = 0; i < totalResult.size(); i++) {
            result[i] = totalResult.get(i);
        }
        
        return result;
    }
}

class Pair {
    LocalTime start;
    LocalTime end;

    public int sumTotal() {
        Duration gap = Duration.between(start, end);

        return (int) gap.toMinutes();
    }

    public int sumEndTotal() {
        Duration gap = Duration.between(start, LocalTime.of(23, 59));

        return (int) gap.toMinutes();
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}

