import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void solution(int n, int m) {
        int answer = 0;
        for (int i = 1; i < 10000; i++) {
            // n,m 둘다 나눠 떨어트릴 수 있는 수 중에서 제일 큰 수가 최대공약수
            if (n % i == 0 && m % i == 0) {
                int max = i;
                answer = Math.max(answer, max);
                if (i > n && i > m) {
                    return;
                }
            }
        }

        System.out.println(answer);
        System.out.println((n / answer) * (m / answer) * answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        solution(n, m);
    }
}