import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// N: 정점 수
// M: 간선 수
// R: 시작 정점
class Main {

    static int n,m,r;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int cnt = 1;

    static void DFS(int v) {
        visited[v] = true; // 그냥 answer로 방문체크 해도됨
        answer[v] = cnt++;

        for (int adj : graph[v]) {
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 5
        m = sc.nextInt(); // 5
        r = sc.nextInt(); // 1

        answer = new int[n + 1];
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

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
            Collections.sort(graph[i]);
        }

        DFS(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}