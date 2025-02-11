import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) { // [3, 2, 7, 2]	[4, 6, 5, 1]
        
        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();
        int N = queue1.length; // 4
        long sum = 0;
        long mid = 0;
        long q1Sum = 0;
        for(int i=0; i<N; i++) {
            sum += queue1[i] + queue2[i];
            q1Sum += queue1[i]; // 14
            Q1.offer(queue1[i]);
            Q2.offer(queue2[i]);
        }
        if(sum % 2 != 0) return -1; // 원소 합 같게 못 만드는 경우
        
        mid = sum/2; // 15
        
        int answer = 0;
        
        while(true) {
            if(answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            
            if(q1Sum == mid) {
                break;
            } else if(q1Sum > mid) {
                int tmp = Q1.poll();
                q1Sum -= tmp;
                Q2.offer(tmp);
            } else if(q1Sum < mid) {
                int tmp = Q2.poll(); // 3
                q1Sum += tmp;
                Q1.offer(tmp); // 4 6 5 1 3
            }
            answer++; // 횟수 ++
        }
        
        return answer;
    }
}