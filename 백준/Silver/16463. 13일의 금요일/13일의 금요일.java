import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = 4;
        int count = 0;
        int month = 0;
        int num = Integer.parseInt(br.readLine());

        for (int year = 2019; year <= num; year++) {
            for (int j = 0; j < 12; j++) {
                if ((year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) && j == 1) {
                    month = arr[j] + 1;
                } else {
                    month = arr[j];
                }
                while (day <= month) {
                    if (day == 13) {
                        count++;
                    }
                    day += 7;
                }
                day = day - month;
            }
        }
        System.out.println(count);
    }
}
