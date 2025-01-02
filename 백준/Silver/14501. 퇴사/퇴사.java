import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 뒤에서부터 dp 배열을 채워 나가면서, i일에 상담을 할 경우, 안할경우 중 최댓값을 저장하여
// 모든 일자를 고려한 후 최종적으로 dp[1]에 가장 큰 이익값을 남기는 로직
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n + 1]; // 상담기간
        int[] P = new int[n + 1]; // 보수

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 테이블 세팅
        // dp[i] : i번째 날부터 퇴사날까지 벌 수 있는 최대 수입
        int[] dp = new int[n + 2];

        // 점화식 구현
        // 뒤에서부터 날짜를 거꾸로 확인한다.
        // i + T[i] 에 해당하는 미래의 dp 값을 이미 계산해둔 상태에서
        // 현재 날짜 i의 최적해를 바로 구할 수 있다
        // 바텀업으로 구현시 자주 사용되는 방법. '미래가 있어야 현재 상태를 확정짓는 문제'
        for (int i = n; i >= 1; i--) {
            // i일에 상담을 진행했을때 상담이 퇴사일을 넘기지 않으면
            if (i + T[i] <= n + 1) {
                // i일 상담을 하지 않은 경우, i일 상담을 한 경우
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            } else {
                // 상담 불가능하면 i일 상담을 건너뜀
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}