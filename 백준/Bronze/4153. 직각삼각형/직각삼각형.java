import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static String solution(int a, int b, int c) {
        int[] num = {a, b, c};
        Arrays.sort(num);
        int x = num[0];
        int y = num[1];
        int z = num[2];

        if (x * x + y * y == z * z) {
            return "right";
        } else {
            return "wrong";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            System.out.println(solution(a, b, c));
        }
    }
}