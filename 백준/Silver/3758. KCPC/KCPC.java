import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int teamNum = Integer.parseInt(st.nextToken());
            int problemNum = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int log = Integer.parseInt(st.nextToken());
            int myTeamScore = 0;

            HashMap<Integer, Team> hashMap = new HashMap<>();

            for (int j = 0; j < log; j++) {
                st = new StringTokenizer(br.readLine());

                int teamId = Integer.parseInt(st.nextToken());
                int pNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (hashMap.containsKey(teamId)) {
                    Team team = hashMap.get(teamId);

                    if (team.hashMap.containsKey(pNum)) {
                        int pScore = team.hashMap.get(pNum);
                        if (pScore < score) {
                            team.totalScore -= pScore;
                            team.totalScore += score;

                            team.hashMap.put(pNum, score);
                        }
                    } else {
                        team.totalScore += score;
                        team.hashMap.put(pNum, score);
                    }

                    team.submitTime++;
                    team.lastSubmit = j;

                    hashMap.put(teamId, team);
                } else {
                    Team team = new Team(teamId, j, 1, score);
                    team.hashMap.put(pNum, score);

                    hashMap.put(teamId, team);
                }
            }

            ArrayList<Team> teams = new ArrayList<>(hashMap.values());
            Collections.sort(teams);

            for (int j = 0; j < teams.size(); j++) {
                Team team = teams.get(j);

                if (team.teamId == myTeamId) {
                    sb.append(j + 1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}

class Team implements Comparable<Team> {
    int teamId;
    int lastSubmit;
    int submitTime;
    int totalScore;

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public Team(int teamId, int lastSubmit, int submitTime, int totalScore) {
        this.teamId = teamId;
        this.lastSubmit = lastSubmit;
        this.submitTime = submitTime;
        this.totalScore = totalScore;
    }

    @Override
    public int compareTo(Team o) {
        if (this.totalScore == o.totalScore) {
            if (this.submitTime == o.submitTime) {
                return Integer.compare(this.lastSubmit, o.lastSubmit);
            }

            return Integer.compare(this.submitTime, o.submitTime);
        }

        return o.totalScore - this.totalScore;
    }
}