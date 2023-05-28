import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n % 2 == 0) {
            System.out.println(n + " is even");
            return;
        } else {
            System.out.println(n + " is odd");
        }
    }
}