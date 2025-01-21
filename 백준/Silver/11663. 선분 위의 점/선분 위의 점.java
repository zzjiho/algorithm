import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 점의 개수 5
        int M = Integer.parseInt(st.nextToken()); // 선분 개수 5
        int[] ar = new int[N]; // 점 좌표

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken()); // 1
            int rt = Integer.parseInt(st.nextToken()); // 10

            // lt보다 같거나 큰값이 처음 나오는 위치 리턴
            int a = lowerBound(ar, lt);

            // rt보다 큰 값이 처음 나오는 위치 리턴
            int b = upperBound(ar, rt);

            // 그렇게해서 둘이 빼주면 선분에 점 몇개 올라가 있는지 알 수 있음.
            int answer = b - a;
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int lowerBound(int[] ar, int lt) {
        int idx = Arrays.binarySearch(ar, lt);
        if (idx < 0) { // binarySearch() 는 찾는값이 배열에 없으면 -idx-1 를 반환한다.
            return -idx - 1;
        } else {
            return idx;
        }
    }

    static int upperBound(int[] ar, int rt) {
        int idx = Arrays.binarySearch(ar, rt);
        if (idx < 0) {
            return -idx - 1;
        } else {
            return idx + 1;
        }
    }
}