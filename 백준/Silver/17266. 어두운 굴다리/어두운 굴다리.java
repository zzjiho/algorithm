import java.io.*;
import java.util.*;

public class Main {

    // 가로등 최소 높이0 부터 최대높이 N 까지 이분 탐색을 한다.
    // 굴다리를 모두 비출 수 없다면 -> 더 높은 높이를 탐색(우측 탐색)
    // 굴다리를 모두 비출 수 있다면 -> 더 낮은 높이를 탐색(좌측 탐색)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 5 (굴다리 길이)
        int M = Integer.parseInt(br.readLine()); // 2 (가로등 개수)

        // 배열 양 끝에 0과 n을 넣어야함
        int[] ar = new int[M+2];
        ar[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        ar[M + 1] = N;

        Arrays.sort(ar);

        // 이분 탐색
        int lt = 0;
        int rt = N;
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt+rt) / 2; // mid: 가로등 높이
            if (check(ar, mid)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 가로등 높이에 따라 굴다리를 다 비출 수 있는지 확인
    static boolean check(int[] ar, int h) {
        // 가로등 가운데 영역 확인
        for (int i = 1; i < ar.length - 2; i++) {
            if (ar[i + 1] - ar[i] > 2 * h) {
                return false;
            }
        }

        // 가로등 가장 왼쪽 확인
        if (ar[1] - ar[0] > h) {
            return false;
        }

        // 가로등 가장 오른쪽 확인
        if (ar[ar.length - 1] - ar[ar.length - 2] > h) {
            return false;
        }

        return true;
    }
}