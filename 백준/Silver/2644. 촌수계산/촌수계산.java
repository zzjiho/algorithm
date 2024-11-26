import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static int n; // 전체사람 수 (정점)
    static int m; // 관계 개수 (간선)
    static int result = -1;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void DFS(int current, int target, int L) {

        if (current == target) {
            result = L;
            return;
        }

        visited[current] = true;

        for (int adj : graph[current]) {
            if (!visited[adj]) {
                DFS(adj, target, L + 1);
                // return 호출되면 이전 호출 스택으로 돌아옴
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 9
        int a = sc.nextInt(); // 7 촌수 계산
        int b = sc.nextInt(); // 3 촌수 계산
        m = sc.nextInt(); // 7

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            graph[c].add(d);
            graph[d].add(c);
        }

        DFS(a, b, 0);

        System.out.println(result);
    }
}