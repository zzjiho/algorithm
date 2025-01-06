import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int a,b;
    static int[] ar;
    static int[] dis;

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(a);
        dis[a] = 0; // 시작 지점 점프 횟수 0

        while (!Q.isEmpty()) {
            int cur = Q.poll();

            // 도착지점 도달
            if (cur == b) {
                System.out.println(dis[cur]);
                return;
            }

            // 징검다리에 적힌 수
            int jump = ar[cur];

            // 앞으로 점프
            for (int i = cur + jump; i <= n; i += jump) {
                // 방문안했으면
                if (dis[i] == -1) {
                    dis[i] = dis[cur] + 1;
                    Q.offer(i);
                }
            }

            // 뒤로 점프
            for (int i = cur - jump; i >= 1; i -= jump) {
                // 방문안했으면
                if (dis[i] == -1) {
                    dis[i] = dis[cur] + 1;
                    Q.offer(i);
                }
            }
        }
        // 도착점에 도달 불가능
        System.out.print(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ar = new int[n + 1];
        dis = new int[n + 1];

        Arrays.fill(dis, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ar[i] = Integer.parseInt(st.nextToken()); 
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); 
        b = Integer.parseInt(st.nextToken()); 

        BFS();
    }
}