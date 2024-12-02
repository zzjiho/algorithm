import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, z;

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int n, m, h;
    static int[][][] board; // 높이,가로,세로
    static int[][][] dis;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Point> Q = new LinkedList<>();

    // 상우하좌앞뒤로 토마토를 익게해야한다.
    static void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;
                int nz = dz[i] + tmp.z;

                // 바운더리내 빈칸으로 이동 가능
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && board[nz][ny][nx] == 0) {
                    board[nz][ny][nx] = 1; // 토마토 익게 만듬
                    dis[nz][ny][nx] = dis[tmp.z][tmp.y][tmp.x] + 1;
                    Q.offer(new Point(nx, ny, nz));
                }
            }
        }
    }

    // 최소 일수 구하는 메소드
    static void solution() {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        answer = Math.max(dis[i][j][k], answer);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][m][n];
        dis = new int[h][m][n];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 익은 토마토들 찾아서 좌표 넣어줌(시작점)
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[i][j][k] == 1) {
                        Q.offer(new Point(k, j, i)); // point는 가로,세로,높이
                    }
                }
            }
        }

        // 인접 토마토 익게 함
        BFS();

        // 최소 일 구하기
        solution();
    }
}
