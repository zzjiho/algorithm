import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] D;

    static int fibo(int n) {
        if (D[n] != -1) {
            return D[n];
        } else {
            return D[n] = fibo(n - 2) + fibo(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        D = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            D[i] = -1;
        }
        D[0] = 0;
        D[1] = 1;

        fibo(n);
        System.out.println(D[n]);
    }
}