import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무 수 4
        int M = Integer.parseInt(st.nextToken()); // 나무 필요 길이 7
        int[] ar = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        long lt = 0;
        long rt = Arrays.stream(ar).max().getAsInt(); // 20
        long answer = 0;

        // 이분탐색 시작
        // 톱 높이 h에 대해서 나무를 다 잘라가지고 그 합이
        // M 보다 작거나 크면 그거에 맞게 lt rt 조절
        while (lt <= rt) {
            long mid = (lt+rt) / 2;
            // 구한 나무 길이들 >= 필요한 나무 길이
            // 톱 높이를 올려야 한다.
            if (count(ar, mid) >= M) {
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }

        System.out.println(answer);
    }

    // 톱 높이로 얻을 수 있는 나무길이 구하는 메소드
    static long count(int[] ar, long h) {
        long max = 0;
        for (int i = 0; i < ar.length; i++) {
            int tree = ar[i];
            if (tree >= h) {
                max += tree - h;
            } else {
                continue;
            }
        }
        return max;
    }
}