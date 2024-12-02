import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y, wall;
    Point(int x, int y, int wall) {
        this.x = x;
        this.y = y;
        this.wall = wall; // 0: 벽을 아직 안 부숨, 1: 벽을 부숨
    }
}

public class Main {
    static int n, m;
    static int[][] board;
    static int[][][] dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 1. 벽을 부수지 않고 이동한 경우, 2. 벽을 부수고 이동한 경우를 구분한다.
    // 같은 위치라도 벽을 부순 여부에 따라 이후 이동 가능성이 달라지므로, 방문 여부와 거리를 각각 관리해야 함..
    static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0, 0));
        dis[0][0][0] = 1; // 시작 위치

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            if (tmp.x == n - 1 && tmp.y == m - 1) {
                System.out.println(dis[tmp.x][tmp.y][tmp.wall]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int wall = tmp.wall;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 갈 수 있는 경로 && 벽 안 부순 상태로 방문한 적이 있니?
                    if (board[nx][ny] == 0 && dis[nx][ny][wall] == 0) {
                        dis[nx][ny][wall] = dis[tmp.x][tmp.y][wall] + 1;
                        Q.offer(new Point(nx, ny, wall));

                    // 다음 위치가 벽 && 아직 벽을 부순 적이 없음 && 벽을 한 번 부순 상태로 방문한 적이 있니?
                    } else if (board[nx][ny] == 1 && wall == 0 && dis[nx][ny][1] == 0) {
                        // 벽을 부수고 이동
                        dis[nx][ny][1] = dis[tmp.x][tmp.y][wall] + 1;
                        Q.offer(new Point(nx, ny, 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dis = new int[n][m][2]; // [x][y][벽 부숨 여부]

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        BFS();
    }
}
