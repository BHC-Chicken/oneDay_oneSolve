import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        StringBuilder sangmin = new StringBuilder();
        StringBuilder jisu = new StringBuilder();

        int sangminTime = Integer.parseInt(split[0]);
        int jisuTime = Integer.parseInt(split[1]);
        int customer = Integer.parseInt(split[2]);

        Queue<Gift> blue = new LinkedList<>();
        Queue<Gift> red = new LinkedList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        int blueCount = 0;
        int redCount = 0;

        int sangminCount = 1;
        int jisuCount = 1;

        int giftIndex = 1;

        for (int i = 0; i < customer; i++) {
            split = br.readLine().split(" ");

            int t = Integer.parseInt(split[0]);
            String c = split[1];
            int giftNumber = Integer.parseInt(split[2]);

            if (c.equals("B")) {
                blue.add(new Gift(t, c, giftNumber));
            } else {
                red.add(new Gift(t, c, giftNumber));
            }
        }

        while (!blue.isEmpty()) {
            Gift gift = blue.poll();

            for (int i = 0; i < gift.giftNumber; i++) {
                blueCount++;
                sangminCount = Math.max(gift.startTime, sangminCount);
                queue.add(new Pair("b", sangminCount));
                sangminCount += sangminTime;
            }
        }

        while (!red.isEmpty()) {
            Gift gift = red.poll();

            for (int i = 0; i < gift.giftNumber; i++) {
                redCount++;
                jisuCount = Math.max(gift.startTime, jisuCount);
                queue.add(new Pair("r", jisuCount));
                jisuCount += jisuTime;
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.peek();

            if (p.name.equals("b")) {
                sangmin.append(giftIndex++).append(" ");
                queue.poll();
                
                if (!queue.isEmpty()) {
                    p = queue.peek();   
                }
            }

            if (p != null && p.name.equals("r")) {
                jisu.append(giftIndex++).append(" ");
                queue.poll();
            }
        }

        System.out.println(blueCount + "\n" + sangmin + "\n" + redCount + "\n" + jisu);
    }
}

class Gift {
    int startTime;
    String color;
    int giftNumber;

    public Gift(int startTime, String color, int giftNumber) {
        this.startTime = startTime;
        this.color = color;
        this.giftNumber = giftNumber;
    }
}

class Pair implements Comparable<Pair> {
    String name;
    int timeIndex;

    public Pair(String name, int timeIndex) {
        this.name = name;
        this.timeIndex = timeIndex;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.timeIndex == o.timeIndex) {
            return this.name.compareTo(o.name);
        }

        return this.timeIndex - o.timeIndex;
    }
}
