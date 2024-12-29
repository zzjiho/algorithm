import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * DP는 전의 결과들을 바탕으로 다음결과를 도출한다고 하는데.
 * 어떤 부분이 [DP 바텀업] 인가?
 *
 * 1. 테이블 정의 (이 테이블을 채워나가면서 모든 조합을 구함)
 *
 * 2. 작은 문제(기본값)부터 채워나간다. (초기값 설정)
 * 바로 알 수 있는 결과(기본값)을 먼저 dp 테이블에 채워놓는 과정이 바텀업 방식의 시작점이다.
 *
 * 3. 점화식으로 더 큰 문제를 해결
 * 이미 구해진 이전행의 dp[i-1][j-1], dp[i-1][j] 정보를 활용해 dp[i][j]를 채운다.
 * 이전 행의 값들이 이미 dp 테이블에 저장되어 있으므로, 그 결과를 재활용해 현재 행을 완성한다.
 * 
 * DP는 "중복되는 계산을 피하고, 이전 계산 결과를 재활용" 하는 것이 핵심이다.
 * 그래서 이전에 계산한 작은 문제들의 해를 dp 테이블에 저장해두었다가 
 * 새롭게 구해야 할 값을 계산할 때 활용하는 것이다. (메모이제이션)
 */
public class Main {

    // 테이블 세팅 (문제에서 최대 30이라 했으니)
    static int[][] dp = new int[31][31];

    // 파스칼 삼각형으로 이항계수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 초기값 설정
            for (int i = 0; i <= 30; i++) {
                // 각 행의 양 끝단 1로 만들기
                dp[i][0] = 1;
                dp[i][i] = 1;
            }

            // 점화식 구현
            for (int i = 1; i <= 30; i++) {
                for (int j = 1; j < i; j++) {
                    // 윗 행의 왼쪽 수 + 오른쪽 수
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }

            System.out.println(dp[m][n]);
        }
    }
}