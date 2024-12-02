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

    static int n, m;
    static int answer = Integer.MIN_VALUE;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // dfs bfs 후 안전영역 사이즈 찾는 메소드
    static void solution(int[][] lab) {
        int cnt = 0; // 카운트 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    cnt++;
                }
            }
        }

        answer = Math.max(cnt, answer);
    }

    // 벽에 막히지 않으면 바이러스 계속 확산 시키는 메소드
    static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        int[][] lab = new int[n][m];

        // 입력값을 받은 board를 복사해서 생성해야 한다.
        // 그래야 바이러스 확산이 된 board에 벽을 세우지 않고 ,
        // 계속 입력값을 받은 board 상태에서 벽을 세울 수 있다.
        for (int i = 0; i < n; i++) {
            // 2차원 배열의 경우, 각 1차원 배열에 대해 clone()을 호출해야 각 행의 독립적인 복사본 생성
            lab[i] = board[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 2) { // 바이러스가 있는 좌표 먼저 따고 (여기서 다 시작)
                    Q.offer(new Point(i, j));
                }
            }
        }

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                // 바운더리내 빈칸으로만 바이러스를 퍼트릴 수 있다
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && lab[nx][ny] == 0) {
                    lab[nx][ny] = 2; // 바이러스 퍼트리기
                    Q.offer(new Point(nx, ny));
                }
            }
        }

        solution(lab);
    }

    // 벽 세우고, 다 세웠을시 백 트래킹
    static void DFS(int cnt) {
        if (cnt == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1; // 벽 세움
                    DFS(cnt+1);
                    board[i][j] = 0; // 벽 제거
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(answer);
    }
}