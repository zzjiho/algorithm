import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력값 받기
        // cost[i][0] : i번째 집을 빨강으로 칠하는 비용
        // cost[i][1] : i번째 집을 초록으로 칠하는 비용
        // cost[i][2] : i번째 집을 파랑으로 칠하는 비용
        int[][] cost = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 빨강 비용
            cost[i][1] = Integer.parseInt(st.nextToken()); // 초록 비용
            cost[i][2] = Integer.parseInt(st.nextToken()); // 파랑 비용
        }

        // dp 테이블 정의
        // dp[i][c] : i번째 집을 색 c로 칠했을 때까지의 최소 비용
        int[][] dp = new int[n + 1][3];

        // 초기값 세팅
        // 첫번째 집의 비용은 초기화
        dp[1][0] = cost[1][0]; // 빨
        dp[1][1] = cost[1][1]; // 초
        dp[1][2] = cost[1][2]; // 파

        // 점화식 구현
        // 두번째 집부터 N번째 집까지 dp 테이블 채우기
        for (int i = 2; i <= n; i++) {
            // i번째 집을 빨강으로 칠하는 경우
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];

            // i번째 집을 초록으로 칠하는 경우
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];

            // i번째 집을 파랑으로 칠하는 경우
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        // 마지막 집까지 칠한 후 최소 비용 계산
        int min = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));

        System.out.println(min);
    }
}