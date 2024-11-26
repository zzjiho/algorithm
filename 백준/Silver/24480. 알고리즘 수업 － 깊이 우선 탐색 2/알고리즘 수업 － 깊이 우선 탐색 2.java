import java.util.*;

// N: 정점 수
// M: 간선 수
// R: 시작 정점
class Main {

    static int n, m, r;
    static int cnt = 1;
    static int[] answer;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void DFS(int v) {
        visited[v] = true;
        answer[v] = cnt++;

        for (int adj : graph[v]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        graph = new ArrayList[n + 1];
        answer = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 세팅
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        // dfs 실행
        DFS(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }

    }
}