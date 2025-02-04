import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) { // 2 3 3 5
        
        // stack에 index 값 넣으면서 풀이
        Stack<Integer> stack = new Stack<>();
        
        int N = numbers.length;
        int[] answer = new int[N]; // 정답배열
        
        // 인덱스 0 stack에 넣기
        stack.push(0);
        
        for(int i=1; i<N; i++) {
            // 뒷큰수 answer에 넣기
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            // 현재 인덱스 stack에 넣기
            stack.push(i);
        }
        // 뒷큰수가 없는 경우 -1 넣기
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}