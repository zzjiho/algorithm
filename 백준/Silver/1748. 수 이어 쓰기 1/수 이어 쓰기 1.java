import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int solution(int n) {
        int length = 10;
        int cnt = 1;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i == length) {
                cnt++;
                length *= 10;
            }
            answer += cnt;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}