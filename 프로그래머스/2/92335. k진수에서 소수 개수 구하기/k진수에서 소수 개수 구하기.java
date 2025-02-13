import java.util.*;

class Solution {
    public int solution(int n, int k) { // 437674	3
        // 0을 만나면 소수인지 판단 == 0으로 나눈게 소수이면 ++ 한다.
        String tmp = ""; // 211020101011
        int answer = 0;
        
        while(n!=0) {
            tmp = n%k+tmp;
            n = n/k;
        }
        
        String[] ar = tmp.split("0"); // 211, 2, 1, 1, 11
        
        for(String x: ar) {
            if(x.equals("")) continue;
            long num = Long.parseLong(x);
            if(isPrime(num)) answer++;
        }
 
        return answer;
    }
    
    public boolean isPrime(long x) {
        if(x < 2) return false;
        
        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x%i==0) return false;
        }
        
        return true;
    }
}