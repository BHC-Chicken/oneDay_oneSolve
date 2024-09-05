import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int next(int index) {
        if (index + 1 >= 8) {
            return 0;
        }

        return index + 1;
    }

    static int prev(int index) {
        if (index - 1 < 0) {
            return 7;
        }

        return index - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] index = {2, 6, 2, 6, 2, 6};
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(new int[8]);

            String[] nums = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                int[] temp = list.get(i);

                temp[j] = Integer.parseInt(nums[j]);
            }
        }

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            String[] cmd = br.readLine().split(" ");
            int wheelNum = Integer.parseInt(cmd[0]) - 1;
            int dir = Integer.parseInt(cmd[1]);
            boolean[] check = new boolean[4];
            check[wheelNum] = true;

            switch (wheelNum) {
                case 0: {
                    int point = 0;

                    for (int j = 1; j < 4; j++) {
                        int[] first = list.get(j - 1);
                        int[] second = list.get(j);

                        if (first[index[point++]] != second[index[point++]]) {
                            check[j] = true;
                        } else {
                            break;
                        }
                    }

                    break;
                }
                case 1: {
                    int[] first = list.get(0);
                    int[] second = list.get(1);

                    if (first[index[0]] != second[index[1]]) {
                        check[0] = true;
                    }

                    int point = 2;
                    for (int j = 2; j < 4; j++) {
                        first = list.get(j - 1);
                        second = list.get(j);

                        if (first[index[point++]] != second[index[point++]]) {
                            check[j] = true;
                        } else {
                            break;
                        }
                    }

                    break;
                }
                case 2: {
                    int[] first = list.get(2);
                    int[] second = list.get(3);

                    if (first[index[4]] != second[index[5]]) {
                        check[3] = true;
                    }

                    int point = 3;
                    for (int j = 1; j >= 0; j--) {
                        first = list.get(j + 1);
                        second = list.get(j);

                        if (first[index[point--]] != second[index[point--]]) {
                            check[j] = true;
                        } else {
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    int point = 5;

                    for (int j = 2; j >= 0; j--) {
                        int[] first = list.get(j + 1);
                        int[] second = list.get(j);

                        if (first[index[point--]] != second[index[point--]]) {
                            check[j] = true;
                        } else {
                            break;
                        }
                    }

                    break;
                }
            }

            if (wheelNum == 0) {
                if (dir == -1) {
                    index[0] = next(index[0]);

                    if (check[1]) {
                        index[1] = prev(index[1]);
                        index[2] = prev(index[2]);
                    }

                    if (check[2]) {
                        index[3] = next(index[3]);
                        index[4] = next(index[4]);
                    }

                    if (check[3]) {
                        index[5] = prev(index[5]);
                    }
                } else {
                    index[0] = prev(index[0]);

                    if (check[1]) {
                        index[1] = next(index[1]);
                        index[2] = next(index[2]);
                    }

                    if (check[2]) {
                        index[3] = prev(index[3]);
                        index[4] = prev(index[4]);
                    }

                    if (check[3]) {
                        index[5] = next(index[5]);
                    }
                }
            } else if (wheelNum == 1) {
                if (dir == -1) {
                    index[1] = next(index[1]);
                    index[2] = next(index[2]);

                    if (check[0]) {
                        index[0] = prev(index[0]);
                    }

                    if (check[2]) {
                        index[3] = prev(index[3]);
                        index[4] = prev(index[4]);
                    }

                    if (check[3]) {
                        index[5] = next(index[5]);
                    }
                } else {
                    index[1] = prev(index[1]);
                    index[2] = prev(index[2]);

                    if (check[0]) {
                        index[0] = next(index[0]);
                    }

                    if (check[2]) {
                        index[3] = next(index[3]);
                        index[4] = next(index[4]);
                    }

                    if (check[3]) {
                        index[5] = prev(index[5]);
                    }
                }
            } else if (wheelNum == 2) {
                if (dir == -1) {
                    index[3] = next(index[3]);
                    index[4] = next(index[4]);

                    if (check[0]) {
                        index[0] = next(index[0]);
                    }

                    if (check[1]) {
                        index[1] = prev(index[1]);
                        index[2] = prev(index[2]);
                    }

                    if (check[3]) {
                        index[5] = prev(index[5]);
                    }
                } else {
                    index[3] = prev(index[3]);
                    index[4] = prev(index[4]);

                    if (check[0]) {
                        index[0] = prev(index[0]);
                    }

                    if (check[1]) {
                        index[1] = next(index[1]);
                        index[2] = next(index[2]);
                    }

                    if (check[3]) {
                        index[5] = next(index[5]);
                    }
                }
            } else {
                if (dir == -1) {
                    index[5] = next(index[5]);

                    if (check[0]) {
                        index[0] = prev(index[0]);
                    }

                    if (check[1]) {
                        index[1] = next(index[1]);
                        index[2] = next(index[2]);
                    }

                    if (check[2]) {
                        index[3] = prev(index[3]);
                        index[4] = prev(index[4]);
                    }
                } else {
                    index[5] = prev(index[5]);

                    if (check[0]) {
                        index[0] = next(index[0]);
                    }

                    if (check[1]) {
                        index[1] = prev(index[1]);
                        index[2] = prev(index[2]);
                    }

                    if (check[2]) {
                        index[3] = next(index[3]);
                        index[4] = next(index[4]);
                    }
                }
            }
        }

        int firstScore = list.get(0)[(index[0] + 6) % 8];
        int secondScore = list.get(1)[(index[2] + 6) % 8];
        int thirdScore = list.get(2)[(index[4] + 6) % 8];
        int fourthScore = list.get(3)[(index[5] + 2) % 8];

        if (secondScore == 1) {
            secondScore = 2;
        }
        if (thirdScore == 1) {
            thirdScore = 4;
        }
        if (fourthScore == 1) {
            fourthScore = 8;
        }

        System.out.println(firstScore + secondScore + thirdScore + fourthScore);
    }
}
