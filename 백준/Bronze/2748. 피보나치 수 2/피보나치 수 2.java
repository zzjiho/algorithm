import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 테이블 세팅
        long[] dp = new long[n + 1];

        // 초기값 세팅
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 1;
        }

        // 점화식 구현
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.print(dp[n]);
    }
}