/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            int num = Integer.parseInt(br.readLine());
            int sum = 0;

            arr = new int[num][num];

            for (int j = 0; j < num; j++) {
                String word = br.readLine();
                for (int k = 0; k < num; k++) {
                    arr[j][k] = Character.getNumericValue(word.charAt(k));
                }
            }

            for (int j = 0; j < num / 2; j++) {
                for (int k = num / 2 - j; k <= (num / 2 + j); k++) {
                    sum += arr[j][k];
                }
            }

            for (int j = num / 2; j >= 0; j--) {
                for (int k = num / 2 - j; k <= (num / 2 + j); k++) {
                    sum += arr[num - j - 1][k];
                }
            }
            sb.append("#").append(i+1).append(" ").append(sum).append("\n");
        }

        System.out.println(sb);
    }

}