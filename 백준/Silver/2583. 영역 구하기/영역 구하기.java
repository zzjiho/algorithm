import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

    static int m; // 행
    static int n; // 열
    static int k; // 개의 직사각형을 그린다.
    static int[][] board;
    static int size;
    static ArrayList<Integer> result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int y, int x) {
        board[y][x] = 1; // 방문처리

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[ny][nx] == 0) {
                size++;
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 5
        n = sc.nextInt(); // 7
        k = sc.nextInt(); // 3
        board = new int[m][n];
        result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1; // 직사각형 칠하기
                }
            }
        }

        // 영역 탐색
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    size = 1;
                    DFS(i, j);
                    // 한 영역 색칠 다 하고 DFS 종료 후 여기로
                    result.add(size);
                }
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();

        sb.append(result.size() + "\n");
        for (int x : result) {
            sb.append(x + " ");
        }
        System.out.println(sb);
    }
}