import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 테이블 세팅 (static 으로 dp 배열 잡으면, 여러 테스트 케이스가 있더라도 반복 사용 가능)
    // dp[i] : i번째 삼각형의 변의 길이
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());

            // 초기값 세팅
            dp[1] = 1; dp[2] = 1; dp[3] = 1;

            // 점화식 구현
            for (int i = 4; i <= 100; i++) {
                // 6번째 삼각형 변의 길이를 구하려면
                dp[i] = dp[i - 3] + dp[i - 2];
            }

            System.out.println(dp[n]);
        }
    }
}