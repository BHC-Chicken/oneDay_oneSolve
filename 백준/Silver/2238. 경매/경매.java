import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Auction> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            map.put(price, map.getOrDefault(price, 0) + 1);

            if (price > u) {
                continue;
            }
            list.add(new Auction(name, price));
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue());

        Collections.sort(list);

        int result = entryList.get(0).getKey();

        for (Auction auction : list) {
            if (result == auction.price) {
                System.out.println(auction.name + " " + auction.price);
                break;
            }
        }
    }
}

class Auction implements Comparable<Auction> {
    String name;
    int price;

    public Auction(String name, int price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public int compareTo(Auction o) {
        return price - o.price;
    }
}
