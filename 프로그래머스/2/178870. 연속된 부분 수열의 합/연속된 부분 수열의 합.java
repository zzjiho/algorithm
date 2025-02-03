import java.io.*;
import java.util.*;

class Solution {
    
    // 투포인터
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int lt=0, rt=0;
        int sum = sequence[0]; 
        
        int bestLen = Integer.MAX_VALUE;
        int bestlt = 0, bestrt=0;
        
        // sum >= k 이면 lt ++ ,
        // sum <= k 이면 rt++
        while(lt < n && rt <n) {
            if(sum < k) {
                rt++;
                if(rt < n) {
                    sum += sequence[rt];
                }
            } else {
                // 합이 k 이상일때, k와 같다면 후보로 검토
                if(sum == k) {
                    int curLen = rt - lt + 1;
                    // 더 짧은 수열이면 갱신
                    if(curLen < bestLen) {
                        bestLen = curLen;
                        bestlt = lt;
                        bestrt = rt;
                    }
                }
                sum -= sequence[lt];
                lt++;
            }   
        }
        return new int[] {bestlt, bestrt};
    }
}