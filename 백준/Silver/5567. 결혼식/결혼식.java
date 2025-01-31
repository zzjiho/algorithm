import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dis; // 각 노드까지 거리

    static void bfs(int v) { // 1 (자신)
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        visited[v] = true;
        dis[v] = 0;

        while(!Q.isEmpty()) {
            int tmp = Q.poll();
            for(int adj : graph[tmp]) {
                if(!visited[adj]) {
                    visited[adj] = true;
                    dis[adj] = dis[tmp] + 1;
                    if(dis[adj] <= 2) {
                        Q.offer(adj);
                    }
                }
            }
        }

        // 1번 자신 제외하고 방문된 노드 수 세기
        int answer = 0;
        for(int i=2; i<=N; i++) {
            if(visited[i] && dis[i] <= 2) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        dis = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }


        bfs(1);
    }
}