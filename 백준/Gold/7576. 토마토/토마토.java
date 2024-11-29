import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int m, n;
    static int[][] board, dis;
    static Queue<Point> Q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) { // 바운더리내 안익은 토마토 익히러 가야함
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 6
        n = Integer.parseInt(st.nextToken()); // 4

        board = new int[n][m];
        dis = new int[n][m];

        // 입력값
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토들은 시작점이다
                if (board[i][j] == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        // 안익은 토마토 있는지 판단
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                } else if (board[i][j] == 1) { // 익었으면 날짜 최대값 찾기
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        }

        if (flag) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}