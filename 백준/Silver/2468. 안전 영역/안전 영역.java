import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int maxHeight = 0;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); 
        board = new int[n][n];
        visited = new boolean[n][n];

        int answer = 1;

        // 입력값 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // 최대 높이 구하기
                if (board[i][j] > maxHeight) {
                    maxHeight = board[i][j];
                }
            }
        }

        for (int h = 1; h < maxHeight; h++) {
            // 방문 배열 초기화
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > h && !visited[i][j]) {
                        DFS(i, j, h);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    static void DFS(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] > h && !visited[nx][ny]) {
                    DFS(nx, ny, h);
                }
            }
        }
    }
}