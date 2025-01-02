import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 5 (개의 수)
        int m = Integer.parseInt(st.nextToken()); // 3 (구해야 하는 횟수)

        // 합배열 선언
        long[] S = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            // 합배열 공식: S[i] = S[i-1] + A[i]
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 구간합: S[j] - S[i-1]
            System.out.println(S[b] - S[a - 1]);
        }
    }
}