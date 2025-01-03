import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String solution(int[] ar) {
        String answer = "LUCKY";
        int sum = 0, sum2 = 0;
        int len = ar.length / 2;

        for (int i = 0; i < ar.length; i++) {
            if (i < len) {
                sum += ar[i];
            } else {
                sum2 += ar[i];
            }
        }

        if (sum == sum2) {
            return answer;
        } else {
            return "READY";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] ar = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ar[i] = str.charAt(i) - '0';
        }

        System.out.println(solution(ar));
    }
}