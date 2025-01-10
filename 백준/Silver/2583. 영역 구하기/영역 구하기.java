import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static int m, n;
    static int k; 
    static int[][] board;
    static boolean[][] visited;
    static int area;
    static int cnt;
    static ArrayList<Integer> answer = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            // 바운더리 내 갈 수 있는 경로
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && board[nx][ny] != 1) {
                    cnt++;
                    dfs(nx, ny);
                }
            }
        }
    }

    static void solution() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] != 1) {
                    area++;
                    cnt = 1;
                    dfs(i, j);
                    answer.add(cnt);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken()); 
        board = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); 
            int y1 = Integer.parseInt(st.nextToken()); 
            int x2 = Integer.parseInt(st.nextToken()); 
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    board[j][k] = 1;
                }
            }
        }

        solution();

        System.out.println(area);

        Collections.sort(answer);
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}