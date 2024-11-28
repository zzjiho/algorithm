import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int answer = 0;
    static char[][] board;
    static boolean[] visitedLetters = new boolean[26]; // A-Z 알파벳 방문 체크
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int letterIndex = board[nx][ny] - 'A';
                if (!visitedLetters[letterIndex]) {
                    visitedLetters[letterIndex] = true;
                    DFS(nx, ny, cnt + 1);
                    visitedLetters[letterIndex] = false; // 백트래킹을 통해 이전 함수의 for문도 마저 실행하여 모든 가능한 경로 탐색
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        visitedLetters[board[0][0] - 'A'] = true; // 시작 위치 알파벳 방문 처리
        DFS(0, 0, 1);
        System.out.println(answer);
    }
}
