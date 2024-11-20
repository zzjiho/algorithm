import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

class Main {

    static int v, e;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

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
        v = sc.nextInt(); // 5
        e = sc.nextInt(); // 6
        int k = sc.nextInt(); // 시작정점 1
        dis = new int[v + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<ArrayList<Edge>>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        T.solution(k);

        for (int i = 1; i <= v; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(dis[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}