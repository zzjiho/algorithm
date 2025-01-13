import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void solution(int N, int M, boolean[] broken) {
        // 1. +/-만 눌러서 이동하기
        // 현재 채널인 100번에서 n까지 이동하는 횟수
        int answer = Math.abs(N - 100);

        // 2. 0부터 1000000까지 모든 채널 번호를 시도
        // (가장 큰 채널번호가 6자리 숫자라 생각)
        // 고장나지 않은 버튼으로 만들 수 있는 채널인지 확인
        for (int ch = 0; ch <= 1000000; ch++) {
            String strCh = String.valueOf(ch);
            boolean isValid = true;

            // 고장난 숫자 들어있는지 확인
            for (int i = 0; i < strCh.length(); i++) {
                int digit = strCh.charAt(i) - '0'; // 문자 -> 숫자
                if (broken[digit]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                // 채널 만들기 위해 누른 횟수 + +/-로 이동해야 하는 횟수
                int cnt = strCh.length() + Math.abs(N - ch);

                if (cnt < answer) {
                    answer = cnt;
                }
            }

        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10]; // 고장난 버튼 수

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int btn = Integer.parseInt(st.nextToken());
                broken[btn] = true;
            }
        }

        solution(N, M, broken);
    }
}