import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[3];

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;

        // 세개 다 눈이 같으면
        if (a == b && b == c) {
            answer = 10000 + a * 1000;
        // 두개만 같으면
        } else if (a == b || a == c || b == c) {
            if (a == b) {
                answer = 1000 + a * 100;
            } else if (a == c) {
                answer = 1000 + a * 100;
            } else if (b == c) {
                answer = 1000 + b * 100;
            }
        // 세개 다 다르면
        } else {
            int max = Math.max(a, Math.max(b, c));
            answer = max * 100;
        }

        System.out.println(answer);
    }
}