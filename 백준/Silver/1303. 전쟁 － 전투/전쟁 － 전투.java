import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n,m; // 행열
    static int white;
    static int blue;
    static int cnt;
    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y) {
        visited[x][y] = true;
        cnt++;
        char tmp = board[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            // 바운더리내 같은 팀
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && board[nx][ny] == tmp) {
                    DFS(nx, ny);
                }
            }
        }
    }

    static void solution() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt=0;
                    DFS(i, j);

                    if (board[i][j] == 'W') { // 방문 안한 'W' 진영
                        white += cnt*cnt;
                    } else if (board[i][j] == 'B') {
                        blue += cnt*cnt;
                    }
                }
            }
        }
    }

    // 각각의 영역을 따로 계산해서 + 해준다음 출력하자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); 

        board = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        solution();
        System.out.print(white + " " + blue);
    }
}