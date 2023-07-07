import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        
        return ((new BigInteger(String.valueOf(a))).add(new BigInteger(String.valueOf(b)))).toString();
    }
}