import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int dp[];
    static int INF = 9999;

    static int solution(int n) {

        if (n < 0) {
            return INF;
        }

        if (n == 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int use3 = solution(n - 3) + 1;
        int use5 = solution(n - 5) + 1;

        dp[n] = Math.min(use3, use5);

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        int answer = solution(n);

        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}