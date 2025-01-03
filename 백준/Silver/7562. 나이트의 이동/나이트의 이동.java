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

class Main {

    static int t, l;
    static int a, b, c, d;
    static int[][] board;
    static int[][] dis;

    // 나이트 이동 범위
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(a, b));
        board[a][b] = 1;

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            if (tmp.x == c && tmp.y == d) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;
                // 바운더리내 갈 수 있는 경로
                if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 1; 
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            dis = new int[l][l];

            // 나이트 현재 칸
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 목적지 칸
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            // 시작점과 목표점이 같으면 이동 횟수는 0
            if (a == c && b == d) {
                System.out.println(0);
                continue;
            }

            BFS();
            System.out.println(dis[c][d]);
        }
    }
}