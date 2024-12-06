import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void solution(int[] num) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int cnt = 0;

        for (int i = 0; i < 9; i++) {
            cnt++;
            if (max < num[i]) {
                max = num[i];
                idx = cnt;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];

        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        solution(num);
    }
}