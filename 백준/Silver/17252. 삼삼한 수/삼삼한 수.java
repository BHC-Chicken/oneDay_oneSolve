import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num == 0) {
            System.out.println("NO");
            
            return;
        }
        
        while (num > 0) {
            if (num % 3 > 1) {
                System.out.println("NO");
                
                return;
            }
            
            num /= 3;
        }

        System.out.println("YES");
    }
}
