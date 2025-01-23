import java.io.*;
import java.util.*;

class Main {

    static int A,K;
    static boolean[] visited;
    static int[] dis;

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        Q.offer(A);
        dis[A] = 0;
        visited[A] = true;

        while (!Q.isEmpty()) {
            int tmp = Q.poll();

            if (tmp == K) {
                System.out.println(dis[tmp]);
                return;
            }

            // 방문하지 않고, 구하고자 하는 값보다 작은경우
            if (tmp + 1 <= K && !visited[tmp + 1]) {
                visited[tmp + 1] = true;
                dis[tmp + 1] = dis[tmp] + 1;
                Q.offer(tmp + 1);
            }

            if (tmp * 2 <= K && !visited[tmp * 2]) {
                visited[tmp * 2] = true;
                dis[tmp * 2] = dis[tmp] + 1;
                Q.offer(tmp * 2);
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[K+1];
        dis = new int[K+1];

        bfs();
    }
}