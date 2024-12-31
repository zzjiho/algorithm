import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 늑대,양 세는것은 counts 배열 같은곳에 담아서 세는게 좋음
// 확장성을 고려해야함. 동물이 늘어나면 복잡해짐.
class Main {

    static int r,c; // 행열
    static int wolf,sheep;
    static int wolfTotal,sheepTotal;
    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y) {
        visited[x][y] = true;

        if (board[x][y] == 'o') {
            sheep++;
        } else if (board[x][y] == 'v') {
            wolf++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            // 바운더리내 방문하지 않으면서, 양이나 늑대인경우
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!visited[nx][ny] && board[nx][ny] != '#') {
                    DFS(nx, ny);
                }
            }
        }
    }

    static void solution() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 방문하지 않은곳 탐색가능
                if (!visited[i][j] && board[i][j] != '#') {
                    wolf = 0; sheep = 0;
                    DFS(i, j);
                    if (wolf >= sheep) {
                        wolfTotal += wolf;
                    } else if (sheep > wolf) {
                        sheepTotal += sheep;
                    }
                }
            }
        }
    }

    // 바운더리내 갈수있는 영역에서 양vs늑대 로 cnt 출력하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        solution();
        System.out.print(sheepTotal + " " + wolfTotal);
    }
}