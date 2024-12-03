import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// n: 번까지 도시
// m: 단방향 수
// k: 최단거리
// x: 출발 정점
public class Main {

    static int n,m,k,x;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dis;

    static void BFS(int x) {
        Queue<Integer> Q = new LinkedList<>();
        visited[x] = true; // 시작점 방문체크
        dis[x] = 0; // 시작점 거리 0
        Q.offer(x);

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            for (int adj : graph[cur]) { // 인접그래프
                if (!visited[adj]) {
                    dis[adj] = dis[cur] + 1; // 거리 업데이트
                    visited[adj] = true; // 방문체크
                    Q.offer(adj); // 큐에 담기
                }
            }
        }
    }

    // 최단 거리가 k 인 도시 출력
    static void solution() {
        boolean flag = false;

        for (int i = 1; i <= n; i++) {
            if (dis[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dis = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        BFS(x);

        solution();
    }
}