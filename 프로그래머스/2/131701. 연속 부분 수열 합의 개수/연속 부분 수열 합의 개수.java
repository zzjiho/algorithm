import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int N = elements.length;
        Set<Integer> s = new HashSet<>();
        int answer = 0;
        
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<N; j++) {
                sum += elements[(i+j) % N]; // 원형
                s.add(sum);
            }
        }
          
        answer = s.size();
        return answer;
    }
}