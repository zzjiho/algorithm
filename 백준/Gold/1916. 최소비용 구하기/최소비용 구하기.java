import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex; // 노드
    int cost; // 비용

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int compareTo(Edge ob) {
        return this.cost - ob.cost; // 비용으로 오름차순
    }
}

class Main {

    static int n; // 정점 수
    static int m; // 간선 수
    static ArrayList<ArrayList<Edge>> graph; // 인접리스트 그래프
    static int[] dis; // 노드들 최단거리 들어가는 배열

    public void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vertex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) {
                continue;
            }
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vertex] > nowCost + ob.cost) {
                    dis[ob.vertex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vertex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        int d = sc.nextInt(); 
        int e = sc.nextInt();
        T.solution(d);
        for (int i = 1; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE && i == e) {
                System.out.println(dis[i]);
            }
        }
    }
}

