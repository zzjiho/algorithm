import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N : 정사각형
public class Main {

    static int n;
    static int cnt; // 영역 수
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y) {
        visited[x][y] = true;
        char tmp = board[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == tmp) {
                DFS(nx, ny);
            }
        }
    }

    // 완전 탐색 시작
    static void solution() {
        cnt = 0; // 영역 수 초기화
        visited = new boolean[n][n]; // 방문 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    DFS(i, j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 정상인 탐색
        solution();
        System.out.print(cnt + " ");

        // 색맹인 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    board[i][j] = 'G';
                }
            }
        }
        solution();
        System.out.print(cnt + " ");
    }
}