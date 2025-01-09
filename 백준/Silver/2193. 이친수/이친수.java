import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 테이블 설정
        // dp[i][0]: 0으로 끝나는 i자리 이친수 개수
        // dp[i][1]: 1로 끝나는 i자리 이친수 개수
        long[][] dp = new long[n + 1][2];

        if (n == 1) {
            System.out.print(1);
            return;
        }

        // 초기값 설정
        dp[1][0] = 0;
        dp[1][1] = 1;

        // 점화식 구현
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.print(dp[n][0] + dp[n][1]);
    }
}