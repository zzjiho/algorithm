import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] ar;
    static int[] dis;

    // 미로를 그래프로 생각하고 각 칸을 정점으로 본다.
    // 점프 가능한 칸들로 이동할 수 있는 간선이 형성됨.
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        dis[0] = 0;
        Q.offer(0);

        while(!Q.isEmpty()) {
            int cur = Q.poll(); // 0
            // 현재 위치에서 점프할 수 있는 모든 칸 확인
            for(int i=1; i<=ar[cur]; i++) {
                int next = cur + i; // 0+1
                // 바운더리내 방문하지 않았으면
                if(next<N && dis[next] == -1) {
                    dis[next] = dis[cur] + 1; // 점프 휫수 갱신
                    Q.offer(next);
                }
            }
        }

        System.out.println(dis[N-1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 미로 크기 10
        ar = new int[N];
        dis = new int[N];

        Arrays.fill(dis, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            ar[i] = Integer.parseInt(st.nextToken()); // 1 2 0 1 3 2 1 5 4 2
        }

        bfs();
    }
}