import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int adj : graph[v]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    static void BFS(int v) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 세팅
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            graph[a].add(b);
            graph[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n+1];
        DFS(v);
        System.out.println();

        visited = new boolean[n+1];
        BFS(v);
    }
}