import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F,S,G,U,D;
    static int[] visited = new int[1000001];

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(S); // 현위치 넣기
        visited[S] = 0; // 시작 위치 체크

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int tmp = Q.poll(); // 1

                if (tmp == G) {
                    System.out.println(visited[tmp]);
                    return;
                }

                int nextUp = tmp+U;
                if (nextUp <= F && visited[nextUp] == -1) {
                    visited[nextUp] = visited[tmp] + 1;
                    Q.offer(nextUp);
                }

                int nextDown = tmp-D;
                if (tmp-D >= 1 && visited[nextDown] == -1) {
                    visited[nextDown] = visited[tmp] + 1;
                    Q.offer(nextDown);
                }
            }
        }

        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 10 층건물
        S = Integer.parseInt(st.nextToken()); // 1 현위치
        G = Integer.parseInt(st.nextToken()); // 10 가야할곳
        U = Integer.parseInt(st.nextToken()); // 2 업
        D = Integer.parseInt(st.nextToken()); // 1 다운

        Arrays.fill(visited, -1);
        BFS();
    }
}