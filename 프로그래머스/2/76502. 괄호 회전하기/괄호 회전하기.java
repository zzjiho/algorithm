import java.util.*;

class Solution {

    public int solution(String s) { // "[](){}"     
        int N = s.length(); // 6
        int answer = 0;
        
        // 길이가 홀수면 정상괄호가 될 수 없다
        if(N % 2 != 0) {
            return 0;
        }
        
        for(int i=0; i<N; i++) {
            String rotated = s.substring(i) + s.substring(0,i);
            if(check(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 정상괄호인지 체크하는 메소드
    public boolean check(String rotated) { // [](){}
        Stack<Character> stack = new Stack<>();
        
        for(char x : rotated.toCharArray()) {
            if(x == '[' || x == '(' || x == '{') {
                stack.push(x);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                // 닫힌괄호 나왔을때 열린 괄호랑 짝 맞는지 확인
                char top = stack.pop();
                if(!pair(top, x)) { // {, }
                    return false;
                }       
            }   
        }
        return true;
    }
    
    // 짝 맞는지 확인하는 메소드
    public boolean pair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
    
}
