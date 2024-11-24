import java.util.Scanner;

class Main {

    static int w; // 너비
    static int h; // 높이
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] board;
    static int cnt; // 섬 개수

    public void DFS(int x, int y) {
        board[x][y] = 0; // 방문 처리
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == 1) { // 갈 수 있는 경로
                DFS(nx, ny);
            }
        }
    }

    public void solution() {
        cnt = 0; // 섬 개수 초기화
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    DFS(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수가 정해져 있지 않음.
        // w와 h가 둘 다 0이 될 때까지 계속 입력을 받아야 함.
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break; // 입력 종료
            }
            board = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            T.solution();
            System.out.println(cnt);
        }
    }
}
