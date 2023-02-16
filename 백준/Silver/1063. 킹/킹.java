import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean check(int kingX, int stoneX, int kingY, int stoneY) {
        return kingX == stoneX && kingY == stoneY;
    }

    public static boolean check2(int a) {
        return a <= 7 && a >= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingWord = st.nextToken();
        String stoneWord = st.nextToken();

        int kingX = kingWord.charAt(0) - 65;
        int kingY = Integer.parseInt(String.valueOf(kingWord.charAt(1))) - 1;
        int stoneX = stoneWord.charAt(0) - 65;
        int stoneY = Integer.parseInt(String.valueOf(stoneWord.charAt(1))) - 1;

        int loop = Integer.parseInt(st.nextToken());

        for (int i = 0; i < loop; i++) {
            String position = br.readLine();
            switch (position) {
                case "R":
                    if (check2(kingX + 1)) {
                        kingX++;
                        if (check(kingX, stoneX, kingY, stoneY) && !check2(stoneX + 1)){
                            kingX--;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneX + 1)) {
                        stoneX++;
                    }
                    break;
                case "L":
                    if (check2(kingX - 1)) {
                        kingX--;
                        if (check(kingX, stoneX, kingY, stoneY) && !check2(stoneX - 1)) {
                            kingX++;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneX - 1)) {
                        stoneX--;
                    }
                    break;
                case "B":
                    if (check2(kingY - 1)) {
                        kingY--;
                        if (check(kingX, stoneX, kingY, stoneY) && !check2(stoneY - 1)) {
                            kingY++;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneY - 1)) {
                        stoneY--;
                    }
                    break;
                case "T":
                    if (check2(kingY + 1)) {
                        kingY++;
                        if (check(kingX, stoneX, kingY, stoneY) && !check2(stoneY + 1)) {
                            kingY--;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneY + 1)) {
                        stoneY++;
                    }
                    break;
                case "RT":
                    if (check2(kingX + 1) && check2(kingY + 1)) {
                        kingX++;
                        kingY++;
                        if (check(kingX, stoneX, kingY, stoneY) && (!check2(stoneX + 1) || !check2(stoneY + 1))) {
                            kingX--;
                            kingY--;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneX + 1) && check2(stoneY + 1)) {
                        stoneX++;
                        stoneY++;
                    }
                    break;
                case "LT":
                    if (check2(kingX - 1) && check2(kingY + 1)) {
                        kingX--;
                        kingY++;
                        if (check(kingX, stoneX, kingY, stoneY) && (!check2(stoneX - 1) || !check2(stoneY + 1))) {
                            kingX++;
                            kingY--;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneX - 1) && check2(stoneY + 1)) {
                        stoneX--;
                        stoneY++;
                    }
                    break;
                case "RB":
                    if (check2(kingX + 1) && check2(kingY - 1)) {
                        kingX++;
                        kingY--;
                        if (check(kingX, stoneX, kingY, stoneY) && (!check2(stoneX + 1) || !check2(stoneY - 1))) {
                            kingX--;
                            kingY++;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneX + 1) && check2(stoneY - 1)) {
                        stoneX++;
                        stoneY--;
                    }
                    break;
                case "LB":
                    if (check2(kingX - 1) && check2(kingY - 1)) {
                        kingX--;
                        kingY--;
                        if (check(kingX, stoneX, kingY, stoneY) && (!check2(stoneX - 1) || !check2(stoneY - 1))) {
                            kingX++;
                            kingY++;
                        }
                    } else {
                        continue;
                    }
                    if (check(kingX, stoneX, kingY, stoneY) && check2(stoneX - 1) && check2(stoneY - 1)) {
                        stoneX--;
                        stoneY--;
                    }
                    break;

            }
        }
        System.out.println((char) (kingX + 65) + "" + (kingY + 1));
        System.out.println((char) (stoneX + 65) + "" + (stoneY + 1));
    }
}
