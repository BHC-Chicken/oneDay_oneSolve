import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int change;
    static String[] nums;
    static int max;

    static void dfs(int start, int depth) {
        if (change == depth) {
            StringBuilder sb = new StringBuilder();
            for (String s : nums) {
                sb.append(s);
            }

            max = Math.max(max, Integer.parseInt(sb.toString()));

            return;
        }

        for (int i = start; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                dfs(i, depth + 1);

                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            String[] input = br.readLine().split(" ");

            nums = input[0].split("");
            change = Integer.parseInt(input[1]);

            if (change > nums.length) {
                change = nums.length;
            }

            dfs(0, 0);

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
            max = 0;
        }

        System.out.println(sb);
    }
}
