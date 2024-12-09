import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int vertex, cost;

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

public class Main {

    static int n; // 도시 수
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    // start: 시작도시 (돌아갈 도시)
    // now: 현재 도시
    // count: 지금까지 방문한 도시 수
    // cost: 현재까지 이동 비용

    // 궁금점 : result 를 구했을때 boolean flag로 true를 줘서 탐색 종료 시키면 안되는지?
    // 최소 비용 경로를 찾아야 하기 때문에 첫번째로 완성된 경로에서 DFS를 종료하면 이후에
    // 발견될 수 있는 더 낮은 비용의 경로를 놓치게되서 안된다.
    static void DFS(int start, int now, int count, int cost) {
        // 모든 도시 방문 완료 후, 시작점으로 돌아가는 경로 있는지 확인
        if (count == n) {
            for (Edge e : graph[now]) {
                if (e.vertex == start) {
                    result = Math.min(result, cost + e.cost);
                    break;
                }
            }
            return;
        }

        // 현재 도시 now에서 이동할 수 있는 모든 다음 도시 탐색
        for (Edge e : graph[now]) {
            int next = e.vertex;
            int nextCost = e.cost;
            // 이미 방문한 도시라면 패스
            if (visited[next]) {
                continue;
            }
            // 방문 처리 후 재귀
            visited[next] = true;
            DFS(start, next, count + 1, cost + nextCost);
            visited[next] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        // 입력값 받기
        int[][] ar = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인접리스트 구성
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 0보다 크면 i -> j로 가는 경로가 있고, 그때 비용이 ar[i][j]
                if (ar[i][j] > 0) {
                    graph[i].add(new Edge(j, ar[i][j])); // 인접리스트에 새로운 간선 추가
                }
            }
        }

        // 시작도시를 1번으로 가정하고 시작
        visited[1] = true;
        DFS(1, 1, 1, 0);

        System.out.println(result);
    }
}