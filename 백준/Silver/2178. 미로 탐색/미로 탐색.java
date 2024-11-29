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

    static int n, m; // 행열
    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y)); // 첫번째 칸 좌표 넣기
        board[x][y] = 0; // 첫번째 칸 벽으로 만들기
        dis[x][y] = 1; // 첫번째 칸 칸수로 포함

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && board[nx][ny] == 1) { // 바운더리내 갈 수 있는 경로
                    board[nx][ny] = 0;
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        dis = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }

        BFS(1, 1);

        System.out.println(dis[n][m]);
    }
}