import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 테이블 세팅
        int[] dp = new int[n + 1];

        // 초기값 세팅
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 3;
        }

        // 점화식 구현
        for (int i = 3; i <= n; i++) {
            // 2X1 타일로 덮었더니 남은건 2Xn-1 칸이다. 이걸 채우는 수는 D[n-1]이다. 이런식
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }

        System.out.println(dp[n]);
    }
}