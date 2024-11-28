import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m; // 행열
    static int cnt = 0;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y) {
        visited[x][y] = true;

        if (board[x][y] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 'X' && !visited[nx][ny]) { // 바운더리내 벽이 아니면
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 도연이 위치 찾기
        int startX = 0, startY = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'I') {
                    startX = i;
                    startY = j;
                    found = true;
                    break;
                }
            }
        }

        // 탐색 시작
        DFS(startX, startY);

        if (cnt >= 1) {
            System.out.println(cnt);
        } else {
            System.out.println("TT");
        }
    }
}
