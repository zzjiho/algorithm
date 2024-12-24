import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 1. 테이블 세팅
        int[] S = new int[n + 1];        // 각 계단 점수를 저장할 배열
        int[] dp = new int[n + 1];       // dp[i]: i번째 계단을 밟을 때 얻을 수 있는 최대 점수

        // 계단 점수 입력 받기
        for (int i = 1; i <= n; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }

        // 예외처리: 계단이 한 개 또는 두 개인 경우
        if (n == 1) {
            System.out.println(S[1]);
            return;
        } else if (n == 2) {
            System.out.println(S[1] + S[2]);
            return;
        }

        // 3. 초기값 설정
        dp[1] = S[1];
        dp[2] = S[1] + S[2];
        dp[3] = Math.max(S[1] + S[3], S[2] + S[3]);

        // 2. 점화식 찾기
        for (int i = 4; i <= n; i++) {
            // (i-2번째 계단 밟고 i번째 계단 올라오기, i-3번째 계단 밟고 i-1번째 계단 밟은 뒤 i번째 계단 올라오기)
            dp[i] = Math.max(dp[i - 2] + S[i], dp[i - 3] + S[i - 1] + S[i]);
        }

        System.out.println(dp[n]);
    }
}