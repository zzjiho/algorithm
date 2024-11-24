import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static int n; // 정점 개수
    static int m; // 간선 개수
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public void DFS(int v) {
        visited[v] = true;

        for (int adj : graph[v]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        
        int cnt = 0; // 연결 요소 개수
        n = sc.nextInt();
        m = sc.nextInt();
        
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++;
                T.DFS(i);
            }
        }

        System.out.println(cnt);
    }
}