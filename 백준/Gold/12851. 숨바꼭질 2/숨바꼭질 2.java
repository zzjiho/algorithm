import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n; // 수빈 위치
    static int k; // 동생 위치
    static int[] visited = new int[100001];
    static int[] count = new int[100001];

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(n);
        visited[n] = 0;
        count[n] = 1;

        while (!Q.isEmpty()) {

            int tmp = Q.poll(); // 현재 위치
            int[] dy = {tmp - 1, tmp + 1, tmp * 2};

            for (int ny : dy) {
                if (ny < 0 || ny > 100000) continue; // 범위 체크

                if (visited[ny] == -1) { // 첫 방문
                    visited[ny] = visited[tmp] + 1;
                    count[ny] = count[tmp];
                    Q.offer(ny);
                } else if (visited[ny] == visited[tmp] + 1) { // 같은 최소 시간으로 도달할 때
                    count[ny] += count[tmp];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수빈 위치
        k = Integer.parseInt(st.nextToken()); // 동생 위치

        Arrays.fill(visited, -1); // 방문 배열 초기화
        BFS();

        System.out.println(visited[k]);
        System.out.println(count[k]);
    }
}