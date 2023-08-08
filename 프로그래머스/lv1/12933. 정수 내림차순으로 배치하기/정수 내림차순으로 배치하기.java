import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();

        List<Long> list = new ArrayList<>();

        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }

        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return Long.parseLong(sb.toString());
    }
}