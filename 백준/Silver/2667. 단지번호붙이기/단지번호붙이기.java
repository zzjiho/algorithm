import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};
    static int n; // 정사각형
    static int cnt; // 단지 수
    static int houseCnt; // 단지 내 집의 수
    static ArrayList<Integer> res = new ArrayList<>();

    public void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { // 갈 수 있는 경로
                board[nx][ny] = 0; // 방문처리
                houseCnt++;
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) { // 집
                    cnt++; // 단지 수 카운트
                    houseCnt = 1;
                    board[i][j] = 0; // 방문처리
                    DFS(i, j, board);
                    res.add(houseCnt);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 7
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next(); // 문자열로 받아서
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0'; // 숫자로 변환
            }
        }

        T.solution(board);
        System.out.println(cnt);

        Collections.sort(res);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
