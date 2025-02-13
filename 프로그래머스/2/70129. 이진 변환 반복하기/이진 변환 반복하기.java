import java.util.*;

class Solution {
    // 1. x의 모든 0 제거하기
    // 2. x의 길이를 2진법으로 바꾸기
    public int[] solution(String s) { // "110010101001"
        int[] answer = new int[2];
        
        // s가 1이 될때까지 계속 반복
        while(!s.equals("1")) {
            int cnt = 0;
            
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') {
                    // s에 0이 있으면 횟수 세야함
                    answer[1]++;
                } else {
                  cnt++;  
                }
            }
            // 0뺀 s의 길이를 이진수로 변경
            s = Integer.toBinaryString(cnt);
            answer[0]++;
        }
        
        return answer;
    }
}