import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 테이블 세팅
        // dp[i][j] = i,j 위치의 최대 자원수
        int[][] dp = new int[n][m];

        // 점화식 구현
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = board[0][0];
                }
                else if (i == 0) { // 왼쪽에서만 오는것
                    dp[i][j] = dp[i][j - 1] + board[i][j];
                } else if (j == 0) { // 위쪽에서만 오는것
                    dp[i][j] = dp[i - 1][j] + board[i][j];
                } else { // 왼쪽칸과 위쪽칸중 더 큰 값을 선택하고 현재 칸의 자원을 더한..
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + board[i][j];
                }
            }
        }

        System.out.print(dp[n-1][m-1]);
    }
}