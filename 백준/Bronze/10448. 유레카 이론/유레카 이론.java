import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int[] nums = new int[46];
        int sum = 0;

        for (int i = 1; i < 46; i ++) {
            sum += i;
            nums[i] = sum;
        }

        for (int i = 0; i < loop; i++) {
            int total = Integer.parseInt(br.readLine());

            System.out.println(brute(nums, total));
        }
    }

    static public int brute(int[] nums, int total) {
        for (int a = 1; a < 46; a++) {
            for (int b = 1; b < 46; b++) {
                for (int c = 1; c < 46; c++) {
                    if ((nums[a] + nums[b] + nums[c]) == total) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}