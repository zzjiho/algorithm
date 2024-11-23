import java.util.Scanner;

class Main {

    static int m; // 가로
    static int n; // 세로
    static int k; // 배추 개수
    static int cnt; // 벌레 수

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1) { // 갈 수 있는 경로
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수

        for (int test = 0; test < t; test++) {
            m = sc.nextInt(); // 10
            n = sc.nextInt(); // 8
            k = sc.nextInt(); // 17
            int[][] board = new int[n][m];
            cnt = 0;

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                board[b][a] = 1; // 배추 심기
            }
            T.solution(board);
            System.out.println(cnt);
        }
    }
}