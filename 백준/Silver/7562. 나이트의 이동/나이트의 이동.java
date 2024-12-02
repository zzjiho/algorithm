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

    static int l;
    static int[][] board;
    static int[][] dis;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}; // 나이트 이동경로
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    // 이동하려는 좌표까지 누가 제일 빨리 도달해 ?
    // 그때의 거리는 몇이야 ?
    static void BFS(Queue<Point> Q, int c, int d) {
        int answer = 0;

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                // 바운더리내 이동 가능 경로
                if (nx >= 0 && nx < l && ny >= 0 && ny < l && board[nx][ny] == 0) {
                    board[nx][ny] = 1; // 이동 표시
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    Q.offer(new Point(nx, ny));

                    if (nx == c && ny == d) {
                        answer = dis[nx][ny];
                    }
                }
            }
        }

        System.out.println(answer);
    }

    // 최단거리가 필요하니 BFS 를 사용한다.
    // 나이트가 갈 수 있는 경로를 좌표로 표현하고 for문을 돌리기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());

        for (int t = 0; t < test; t++) {
            Queue<Point> Q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            board = new int[l][l];
            dis = new int[l][l];

            // 체스 현재 위치 Q에 담기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Q.offer(new Point(a, b));

            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 나이트 현재 위치 == 이동 위치 일때
            if (a == c && b == d) {
                System.out.println(0);
                continue;
            }

            BFS(Q, c, d);
        }
    }
}