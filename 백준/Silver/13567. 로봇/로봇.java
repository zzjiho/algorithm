import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[M][M];

        // 수학 좌표계
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        // 로봇 현재 위치 (0, 0)
        int x = 0, y=0;

        // 방향 (0:동, 1:서, 2:남, 3:북)
        // 처음엔 동쪽을 바라본다.
        int dir = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            if (command.equals("MOVE")) {
                // n만큼 앞으로간다.
                x += dx[dir] * val;
                y += dy[dir] * val;
            } else if (command.equals("TURN")) {
                // 왼쪽으로 90도 회전
                if (val == 0) {
                    dir = (dir + 3) % 4;
                } else { // 오른쪽으로 회전
                    dir = (dir + 1) % 4;
                }
            }

            //(M,M) 범위를 벗어나면 안됨
            if (x < 0 || x > M || y < 0 || y > M) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(x + " " + y);
    }
}