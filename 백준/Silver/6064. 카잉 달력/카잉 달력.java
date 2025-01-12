import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 최대공약수
    static int gcd(int m, int n) {
        if (n==0) return m;
        return gcd(n, m % n);
    }

    // 최소공배수
    static int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }

    static void solution(int m, int n, int x, int y) {
        int answer = -1;

        // 최소 공배수 계산 (카잉 달력 마지막 해)
        int doomsDay = lcm(m,n);

        while (x <= doomsDay) {
            if (x % n == y % n) {
                answer = x;
                break;
            }
            x += m;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken());
            solution(m, n, x, y);
        }
    }

}
