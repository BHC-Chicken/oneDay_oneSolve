import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 1; i <= test_case; i++) {
            int[][] arr = new int[9][9];
            boolean flag = true;

            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 9; j++) {
                int[] nums = new int[10];
                for (int k = 0; k < 9; k++) {
                    if (nums[arr[j][k]] >= 1) {
                        flag = false;
                        break;
                    } else {
                        nums[arr[j][k]]++;
                    }
                }
            }

            if (!flag) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }

            for (int j = 0; j < 9; j++) {
                int[] nums = new int[10];
                for (int k = 0; k < 9; k++) {
                    if (nums[arr[k][j]] >= 1) {
                        flag = false;
                        break;
                    } else {
                        nums[arr[k][j]]++;
                    }
                }
            }

            if (!flag) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }

            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k += 3) {
                    int[] nums = new int[10];
                    for (int l = j; l < j + 3; l++) {
                        for (int o = k; o < k + 3; o++) {
                            if (nums[arr[l][o]] >= 1) {
                                flag = false;
                                break;
                            } else {
                                nums[arr[l][o]]++;
                            }
                        }
                    }
                }
            }

            if (!flag) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }

            sb.append("#").append(i).append(" ").append(1).append("\n");
        }

        System.out.println(sb);
    }
}