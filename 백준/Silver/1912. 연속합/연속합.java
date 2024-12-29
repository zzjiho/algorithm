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
        // dp[i] : i번째 원소를 마지막으로 포함하는 연속된 수의 최대 연속합
        int[] dp = new int[n + 1];

        // 초기값 세팅
        dp[0] = ar[0];
        int max = ar[0];

        // 점화식 구현
        for (int i = 1; i < n; i++) {
            // 카데인 알고리즘
            dp[i] = Math.max(dp[i - 1] + ar[i], ar[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}