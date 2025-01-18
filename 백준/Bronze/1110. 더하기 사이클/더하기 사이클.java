import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt = 0;

    static int cycle(int N) {
        cnt++;
        int a = N / 10;
        int b = N % 10;
        int sum = a + b;
        return b * 10 + (sum % 10);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int origin = N;

        while (true) {
            N = cycle(N);
            if (origin == N) {
                System.out.println(cnt);
                break;
            }
        }
    }
}