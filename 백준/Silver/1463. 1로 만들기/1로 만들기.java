import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;

    // 바텀업
    // dp[n] : 정수 n을 1로 만드는 데 필요한 최소 연산 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나눠 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // +1은 연산 횟수 추가
            }

            // 3으로 나눠 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}