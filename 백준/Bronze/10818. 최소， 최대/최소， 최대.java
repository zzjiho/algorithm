import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void solution(int n, int[] ar) {
        int max = ar[0];
        int min = ar[0];

        for (int i = 0; i < n; i++) {
            if (min > ar[i]) {
                min = ar[i];
            }

            if (max < ar[i]) {
                max = ar[i];
            }
        }
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, ar);
    }
}