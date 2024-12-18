import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String solution(String str) {
        String answer = "NO";

        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                if (stack.isEmpty()) {
                    return answer;
                }
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        if (!stack.isEmpty()) {
            return answer;
        } else {
            return "YES";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            System.out.println(solution(str));
        }
    }
}