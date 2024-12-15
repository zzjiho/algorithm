import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 소수 찾는 메소드
    // 제곱근 넘어서 소수 판별해봐야 의미가 없다.
    // 제곱근까지의 수로 나눠떨어지지 않으면 그 수는 소수다.
    static boolean isPrime(int num) {
        if (num < 2) { // 2보다 작으면 소수가 아님
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    static void solution(int n, int[] num) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(num[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, num);
    }
}