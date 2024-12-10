import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int vertex;
    int cost;

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

public class Main {

    static int n;
    static boolean[] visited;
    static ArrayList<Edge>[] graph;
    static int result = Integer.MAX_VALUE;

    static void DFS(int start, int now, int count, int cost) {
        // 현재까지 비용이 이미 최소 비용보다 크면 탐색 종료
        if (cost >= result) {
            return;
        }

        // 모든 도시를 순회했을때
        if (count == n) {
            // 다시 돌아왔냐? 체크
            for (Edge e : graph[now]) {
                if (e.vertex == start) {
                    result = Math.min(result, cost + e.cost);
                    break;
                }
            }
            return;
        }

        for (Edge e : graph[now]) {
            int nextVertex = e.vertex;
            int nextCost = e.cost;

            // 이미 방문한 도시라면 패스
            if (!visited[nextVertex]) {
                visited[nextVertex] = true;
                DFS(start, nextVertex, count + 1, cost + nextCost);
                visited[nextVertex] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 4
        visited = new boolean[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 입력값 받기
        int[][] ar = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 갈수있는 경로가 있으면 간선 세팅
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ar[i][j] > 0) {
                    graph[i].add(new Edge(j, ar[i][j]));
                }
            }
        }

        // 도시 1부터 방문한다고 가정
        visited[1] = true;
        DFS(1, 1, 1, 0);
        System.out.println(result);
    }
}