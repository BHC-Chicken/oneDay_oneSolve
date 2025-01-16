import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int mineralLoop = minerals.length / 5;
        if (minerals.length % 5 > 0) {
            mineralLoop++;
        }
        int pick = picks[0] + picks[1] + picks[2];

        int loop = Math.min(pick, mineralLoop);

        ArrayList<Mineral> list = new ArrayList<>();

        int index = 0;

        for (int i = 0; i < loop; i++) {
            int diaCount = 0;
            int ironCount = 0;
            int stoneCount = 0;

            for (int j = 0; j < 5; j++) {
                String m = minerals[index++];

                if (m.equals("diamond")) {
                    diaCount++;
                } else if (m.equals("iron")) {
                    ironCount++;
                } else {
                    stoneCount++;
                }

                if (index >= minerals.length) {
                    break;
                }
            }

            list.add(new Mineral(diaCount, ironCount, stoneCount));
        }

        Collections.sort(list);

        for (Mineral mineral : list) {
            if (picks[0] > 0) {
                answer += (mineral.diamond + mineral.iron + mineral.stone);
                picks[0]--;
            } else if (picks[1] > 0) {
                int sum = mineral.diamond * 5;
                sum += mineral.iron;
                sum += mineral.stone;

                answer += sum;
                picks[1]--;
            } else {
                int sum = mineral.diamond * 25;
                sum += mineral.iron * 5;
                sum += mineral.stone;

                answer += sum;
                picks[2]--;
            }
        }

        return answer;
    }
}

class Mineral implements Comparable<Mineral> {
    int diamond;
    int iron;
    int stone;

    public Mineral(int diamond, int iron, int stone) {
        this.diamond = diamond;
        this.iron = iron;
        this.stone = stone;
    }

    @Override
    public int compareTo(Mineral o) {
        if (this.diamond == o.diamond) {
            if (this.iron == o.iron) {
                return o.stone - this.stone;
            }

            return o.iron - this.iron;
        }

        return o.diamond - this.diamond;
    }
}

