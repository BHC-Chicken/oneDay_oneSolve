import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public String[] solution(String[] record) {
        Map<String, User> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        StringTokenizer st;
        for (String s : record) {
            st = new StringTokenizer(s);

            String status = st.nextToken();
            String uid = st.nextToken();
            String name = "";
            if (st.hasMoreTokens()) {
                name = st.nextToken();
            }

            if (map.containsKey(uid)) {
                User temp = map.get(uid);
                if (!name.equals("")) {
                    temp.name = name;
                }
                if (!status.equals("Change")) {
                    temp.status.add(status);
                    list.add(uid);
                }
                map.put(uid, temp);
            } else {
                map.put(uid, new User(status, name));
                list.add(uid);
            }
        }

        String[] answer = new String[list.size()];
        int index = 0;

        for (String s : list) {
            User user = map.get(s);
            if (user.status.poll().equals("Enter")) {
                answer[index] = user.name + "님이 들어왔습니다.";
            } else {
                answer[index] = user.name + "님이 나갔습니다.";
            }
            index++;
        }
        return answer;
    }
}

class User {
    Queue<String> status = new LinkedList<>();
    String name;
    
    public User(String status, String name) {
        this.status.add(status);
        this.name = name;
    }
}