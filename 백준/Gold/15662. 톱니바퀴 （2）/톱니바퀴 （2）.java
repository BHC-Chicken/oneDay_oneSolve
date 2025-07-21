import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static void move(ArrayList<Integer> temp, int dir) {
        if (dir == 1) {
            temp.add(0, temp.remove(temp.size() - 1));
        } else if (dir == -1) {
            temp.add(temp.remove(0));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> arrayList = list.get(i);
            String[] split = br.readLine().split("");

            for (int j = 0; j < 8; j++) {
                arrayList.add(Integer.parseInt(split[j]));
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arrayList = list.get(index);

            int right = arrayList.get(2);
            int left = arrayList.get(6);

            int tempRight = right;
            int tempLeft = left;
            int tempDir = dir;

            move(arrayList, dir);

            for (int j = index - 1; j >= 1; j--) {
                arrayList = list.get(j);
                int nowRight = arrayList.get(2);

                if (tempLeft != nowRight) {
                    tempLeft = arrayList.get(6);

                    if (tempDir == -1) {
                        tempDir = 1;
                        move(arrayList, tempDir);
                    } else {
                        tempDir = -1;
                        move(arrayList, tempDir);
                    }
                } else {
                    break;
                }
            }

            tempDir = dir;

            for (int j = index + 1; j <= n; j++) {
                arrayList = list.get(j);
                int nowLeft = arrayList.get(6);

                if (tempRight != nowLeft) {
                    tempRight = arrayList.get(2);

                    if (tempDir == -1) {
                        tempDir = 1;
                        move(arrayList, tempDir);
                    } else {
                        tempDir = -1;
                        move(arrayList, tempDir);
                    }
                } else {
                    break;
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> arrayList = list.get(i);

            if (arrayList.get(0) == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
