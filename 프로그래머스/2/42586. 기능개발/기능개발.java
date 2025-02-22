import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) { // [93, 30, 55]	[1, 30, 5]
        
        int N = progresses.length; // 3
        int[] days = new int[N];
        
        for(int i=0; i<N; i++) {
            int remain = 100 - progresses[i]; // 7
            int num = (int) Math.ceil((double)remain / speeds[i]); // 반올림 처리해야 마지막 테케 통과
            days[i] = num; 
        }
        
        List<Integer> deploy = new ArrayList<>();
        int max = days[0];
        int cnt = 1;
        
        for(int i=1; i<N; i++) { // 3
            if(days[i] <= max) {
                // 얘는 그럼 배포못함
                cnt++;
            } else {
                // 배포 되는 기능
                deploy.add(cnt);
                cnt = 1;
                max = days[i];
            }
        }
        deploy.add(cnt);
        
        int[] answer = new int[deploy.size()];
        for(int i=0; i<deploy.size(); i++) {
            answer[i] = deploy.get(i);
        }
        return answer;
    }
}

