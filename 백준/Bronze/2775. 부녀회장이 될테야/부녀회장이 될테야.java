import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine()); // 1 (층)
            n = Integer.parseInt(br.readLine()); // 3 (호)

            int MAX = 15;

            // 테이블 세팅
            int[][] dp = new int[MAX][MAX];

            // 초기값 세팅
            // 0층 초기화
            for (int n = 1; n < MAX; n++) {
                dp[0][n] = n;
            }

            // 점화식 구현
            for (int k = 1; k < MAX; k++) {
                for (int n = 1; n < MAX; n++) {
                    // 같은층의 바로 앞 호수까지합 + 한층아래의 n호까지 인원수
                    dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}