import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int MAX = 100001; // 위치 최대값
    static int[] visited = new int[1000001];

    static void BFS(int n, int k) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n); // 수빈이 넣고
        visited[n] = 1; // 시작 위치를 방문 표시 (시간을 1로 설정)

        while (!Q.isEmpty()) {
            int tmp = Q.poll();

            if (tmp == k) { // 동생 위치에 도달시
                System.out.println(visited[tmp] - 1);
                return;
            }

            int[] dy = {tmp - 1, tmp + 1, tmp * 2};

            for (int ny : dy) {
                if (ny >= 0 && visited[ny] == 0 && ny < MAX) {
                    Q.offer(ny);
                    visited[ny] = visited[tmp] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        BFS(n, k);
    }
}