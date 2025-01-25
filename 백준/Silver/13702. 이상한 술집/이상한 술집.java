import java.io.*;
import java.util.*;

public class Main {
    // K명에게 최대한의 많은 양의 막거리 분배할 수 있는 양은?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주전자 수 2
        int K = Integer.parseInt(st.nextToken()); // 친구 수 3

        long[] ar = new long[N]; // 막걸리 양 담는 배열

        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(br.readLine()); // 702 429
        }

        long max = Arrays.stream(ar).max().getAsLong(); // 702

        long lt = 1;
        long rt = max;
        long answer = 0;

        while (lt <= rt) {
            long cnt = 0;
            long mid = (lt+rt)/2; // (1+702)/2 = 351

            // mid값(친구들에게 나눌 수 있는 막걸리 용량) 으로 몇명까지 나눌수있는지 ?
            for(int i=0; i<N; i++) {
                cnt += ar[i]/mid;
            }

            // 친구들에게 다 나눠줄 수 있으면
            if(cnt>=K) {
                // 막걸리양을 좀 더 늘려봐야겠지 ?
                lt = mid+1;
                answer = mid;
            } else {
                rt = mid-1;
            }
        }

        System.out.println(answer);
    }
}