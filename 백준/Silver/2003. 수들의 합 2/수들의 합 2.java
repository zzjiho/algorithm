import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int solution(int n, int m, int[] ar) {
        int sum = 0;
        int answer = 0;
        int lt = 0, rt = 0;

        // 오른쪽 포인터가 배열 끝까지 도달할 때까지 반복
        // rt가 n까지 증가할 수 있도록하면 ar[n]에 접근시 0을 더하게 되어
        // sum에 영향을 주지 않으면서도 배열 범위를 벗어나지 않음.
        // 별도의 종료 조건을 추가하지 않고도 루프를 안전하게 종료 시킨다.
        while (rt <= n) {
            // 현재 합이 목표값 이상이면 왼쪽 포인터 이동해서 합을 줄임
            if (sum >= m) {
                sum -= ar[lt++];
            } else if (sum < m) {
                sum += ar[rt++];
            }
            if (sum == m) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ar = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, m, ar));
    }
}