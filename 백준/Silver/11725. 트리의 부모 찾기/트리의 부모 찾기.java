import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer; // 부모 노드 저장할 배열

    public void DFS(int v) {
        visited[v] = true;

        for (int adj : graph[v]) {
            if (!visited[adj]) {
                answer[adj] = v;
                DFS(adj);
            }
        }
    }

    // 현재 노드는 다음 노드의 부모노드가 된다.
    // 그러므로 다음 노드로 이동하기 직전에 현재 노드를 answer에 담는다.
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 7
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        T.DFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}