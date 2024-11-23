import java.util.*;

class Main {

    static int n; // 노드 수
    static int m; // 간선 수
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt;

    public void DFS(int v) {
        visited[v] = true;

        for (int adj : graph[v]) {
            if (!visited[adj]) {
                cnt++;
                DFS(adj);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 세팅 및 그래프 구성
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        T.DFS(1);
        System.out.println(cnt);
    }
}
