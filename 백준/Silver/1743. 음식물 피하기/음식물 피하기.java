
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N: 세로길이
// M: 가로길이
// K: 음식물 쓰레기 개수
public class Main {

    static int n, m, k;
    static boolean[][] visited;
    static int[][] board;
    static int size;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y) {
        visited[x][y] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) { // 바운더리 안에 있고 쓰레기인경우
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) { // 방문하지 않고, 쓰레기이면
                    size = 0;
                    DFS(i, j);
                    answer = Math.max(answer, size);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; // -1로 받아서 배열 인덱스 맞추기
            int b = Integer.parseInt(st.nextToken()) - 1;
            board[a][b] = 1; // 쓰레기
        }

        solution();
        System.out.println(answer);
    }
}
