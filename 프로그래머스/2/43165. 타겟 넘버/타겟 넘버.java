import java.util.*;

class Solution {
    
    static int answer = 0;
    
    static void dfs(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length) { // numbers의 모든 요소를 사용해서 target 을 구해야 하므로
           if(sum == target) { // 조건에 만족
               answer ++;
           } 
           return;
        } else {
            dfs(numbers, target, idx+1, sum+numbers[idx]);
            dfs(numbers, target, idx+1, sum-numbers[idx]);
        }
    }
    
    public int solution(int[] numbers, int target) { // ([1,1,1,1,1], 3)
        int N = numbers.length;
        dfs(numbers, target, 0, 0);
        return answer;
    }
}