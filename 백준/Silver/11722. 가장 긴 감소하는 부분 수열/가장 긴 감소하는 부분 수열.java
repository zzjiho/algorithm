import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력값 받기
        int[] ar = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        // 테이블 세팅
        // dp[i] : i번째 원소를 마지막 원소로 갖는 가장 긴 감소하는 부분 수열의 길이
        int[] dp = new int[n];

        // 초기값 설정
        // 자기 자신만 LDS로 볼 수 있으므로 초기값을 1로 설정
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // 점화식 구현
        for (int i = 1; i < n; i++) {
            // 첫 원소부터 i원소 전까지 비교
            for (int j = 0; j < i; j++) {
                if (ar[i] < ar[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}