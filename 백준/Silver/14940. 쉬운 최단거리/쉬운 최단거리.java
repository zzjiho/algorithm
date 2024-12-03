import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 각 지점에서 모든 지점에 대해 목표지점까지 거리 출력하기
// 0: 못감, 1:땅, 2: 목표지
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m; // 행열
    static int[][] map;
    static int[][] dis;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q = new LinkedList<>();

    // 출발점에서 모든 지점까지 거리를 구하는 BFS
    // map 에 직접 방문 표시하면
    // 그 위치가 원래 갈 수 있는 땅인지(1) 또는 갈 수 없는 땅인지(0) 구분할 수 없게 됨
    static void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                // 바운더리내 갈 수 있는 땅
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    Q.offer(new Point(nx, ny));
                }
            }

        }
    }

    // 모든 지점까지의 거리를 출력하는 메소드
    static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.print(0 + " ");
                } else if (map[i][j] == 1 && !visited[i][j]) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(dis[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dis = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도착점 찾아서 Q에 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        BFS();

        solution();
    }
}