import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int INF = 9999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[i] = i kg 설탕을 최소 봉지로 가져가는 수
        // 1. 테이블 세팅
        int[] dp = new int[n + 1];

        // 2. 초기화 세팅
        Arrays.fill(dp, INF);
        dp[0] = 0; // 0kg 은 봉지를 안쓴다.

        // 3. 점화식 구현
        for (int i = 1; i <= n; i++) {
            // 3kg 봉지 쓸 수 있는 경우
            if (i - 3 >= 0 && dp[i - 3] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }

            // 5kg 봉지 쓸 수 있는 경우
            if (i - 5 >= 0 && dp[i - 5] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        System.out.println((dp[n] == INF) ? -1 : dp[n]);
    }
}