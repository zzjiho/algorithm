import java.io.*;
import java.util.*;

public class Main {

    static int count(int[] ar, int mid) {
        int cnt = 1;
        int sum = 0;
        for (int x : ar) {
            if (sum + x > mid) { // 넘으면 블루레이 +1
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }

    static void solution(int N, int M, int[] ar) {
        int answer = 0;
        int lt = Arrays.stream(ar).max().getAsInt(); // 배열의 모든 요소 중 가장 큰 원소 갖고오기
        int rt = Arrays.stream(ar).sum();

        // 이진탐색 시작
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // (9+45)/2 == 27
            if (count(ar, mid) <= M) { // 블루레이 몇개필요한지 count 메소드로 세고 M 보다 작거나 같으면
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 9 (강의 수)
        int M = Integer.parseInt(st.nextToken()); // 3 (블루레이 수)
        int[] ar = new int[N]; // 강의길이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, M, ar);
    }
}