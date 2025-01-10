import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] ar;

    static int solution(int k) {
        int answer = 0;

        // k가 1, 3, 6, 10, 15, 21 .. 이 수 3개를 이용해서 표현 할 수 있니 ?
        ar = new int[k+1];
        ar[1] = 1; ar[2] = 3;

        for (int i = 3; i <= k; i++) {
            ar[i] = (ar[i - 1] - ar[i - 2]) + 1 + ar[i-1];
        }

        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= k; j++) {
                for (int l = j; l <= k; l++) {
                    if (ar[i] + ar[j] + ar[l] == k) {
                        return 1;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(solution(k));
        }
    }
}