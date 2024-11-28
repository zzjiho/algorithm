import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r,c; //행열
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int totalSheep = 0;
    static int totalWolf = 0;

    // DFS로 영역을 탐색하고 양,늑대의 수를 센다.
    static void DFS(int x, int y, int[] counts) {
        visited[x][y] = true;

        if (board[x][y] == 'o') {
            counts[0]++;
        } else if (board[x][y] == 'v') {
            counts[1]++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) { // 바운더리내에서 울타리 아닌곳 이동가능
                if (!visited[nx][ny] && board[nx][ny] != '#') {
                    DFS(nx, ny, counts);
                }
            }
        }
    }

    // 모든 영역 탐색 및 생존한 양,늑대 세기
    static void solution() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && board[i][j] != '#') {
                    int[] counts = new int[2]; // 새로운 영역마다 count 초기화, [0] = 양, [1] = 늑대
                    DFS(i, j, counts);
                    if (counts[0] > counts[1]) { // 양이 더 많으면 늑대 몰살
                        totalSheep += counts[0];
                    } else {
                        totalWolf += counts[1]; // 늑대 >= 양 이면 양 몰살
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 6
        c = Integer.parseInt(st.nextToken()); // 6
        board = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        solution();
        System.out.println(totalSheep + " " + totalWolf);
    }
}