import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N = 19;
    static int[][] board = new int[N+1][N+1];

    // 가로, 세로, 대각선 ↘, 대각선 ↙ 만 판단하면 됨
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] != 0) {
                    int tmp = board[i][j];

                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;

                        int cnt = 1;

                        // 오목인지 확인
                        while (isValid(nx, ny) && board[nx][ny] == tmp) {
                            cnt++;
                            nx += dx[k];
                            ny += dy[k];
                        }

                        // 오목 완성하면
                        if (cnt == 5) {
                            // 6목 이상인지 판단
                            // 탐색 시작한 위치전, 후로 두번 확인해야함
                            int prevX = i - dx[k];
                            int prevY = j - dy[k];
                            if (isValid(prevX, prevY) && board[prevX][prevY] == tmp) {
                                continue; // 이전 칸도 같은 색이므로 무효
                            }

                            // 2) 연속 끝 다음 칸 확인
                            if (isValid(nx, ny) && board[nx][ny] == tmp) {
                                continue; // 다음 칸도 같은 색이므로 무효
                            }

                            System.out.println(tmp);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        // 승부 안났을때
        System.out.println(0);
    }

    static boolean isValid(int x, int y) {
        return (x > 0 && x <= N && y > 0 && y <= N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }
}