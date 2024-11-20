import java.util.*;

class Main {

    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int adj : graph[v]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        visited[v] = true;
        Q.offer(v);

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            System.out.print(cur + " ");

            for (int adj : graph[cur]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    Q.offer(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

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

        // 인접 리스트에 추가되는 정점들은 입력 순서대로 저장되니,
        // 문제 요구사항에 맞게 정점 번호를 작은 순서대로 정렬해야함
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 실행
        visited = new boolean[n + 1];
        T.DFS(v);
        System.out.println();

        // BFS 실행
        visited = new boolean[n + 1]; // 다시 초기화
        T.BFS(v);
    }
}







