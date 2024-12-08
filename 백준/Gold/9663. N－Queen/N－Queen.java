import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;                   // 체스판의 크기 (N x N)
    static int[] queenPositions;    // queenPositions[row] = 그 행에 놓인 퀸의 열 위치
    static int answer = 0;

    /**
     * placeQueen(row):
     * row 행에 퀸을 놓을 수 있는 모든 열 위치를 시도하는 함수.
     * 만약 row == N이라면 0행부터 N-1행까지 퀸을 모두 놓은 것이므로 solutionCount를 증가.
     * 그렇지 않다면 현재 row에 가능한 열(col)에 퀸을 놓고, 다음 행으로 진행한다.
     */
    static void placeQueen(int row) {
        // 만약 현재 row가 N이라면, 모든 행에 퀸을 성공적으로 배치한 상태
        if (row == n) {
            answer++;
            return;
        }

        // 현재 행(row)에 퀸을 놓을 열(col)을 하나씩 시도한다.
        for (int col = 0; col < n; col++) {
            // 현재 (row, col) 위치에 퀸을 놓을 수 있는지 검사
            if (canPlaceQueen(row, col)) {
                // 놓을 수 있다면 queenPositions[row]에 해당 열 정보 저장
                queenPositions[row] = col; // ~행에 위치한 퀸의 열 위치 제공

                // 다음 행으로 넘어가서 퀸 배치 시도
                placeQueen(row + 1);

                // 여기서 백트래킹으로 돌아오면 다른 col에 대한 시도를 계속한다.
                // 별도의 해제 연산(ch[row] = false 등)은 필요 없다.
                // 왜냐하면 queenPositions는 다시 col 값으로 덮어쓰는 방식이라 이전 상태로 "자동 복구"된다.
            }
            // 만약 canPlaceQueen이 false라면, 그냥 다음 col로 넘어가서 시도한다.
        }
    }

    /**
     * canPlaceQueen(r, c):
     * (r, c) 위치에 퀸을 놓을 때, 이전에 놓인 퀸들과 충돌이 없는지 확인하는 함수.
     * 검사할 조건:
     * 1) 같은 열에 퀸이 있는지?
     * 2) 대각선 방향에 퀸이 있는지?
     *
     * queenPositions[i] = i행에 놓은 퀸의 열 위치
     * 현재 r행에 c열에 놓으려 할 때,
     *   - 열 충돌: queenPositions[i] == c
     *   - 대각선 충돌: |r - i| == |c - queenPositions[i]|
     */
    static boolean canPlaceQueen(int r, int c) { // r행의 c열에 퀸이 들어갈 수 있어 ? 확인하는 함수
        // 0행부터 r-1행까지 이미 놓인 퀸들과 비교
        for (int prevRow = 0; prevRow < r; prevRow++) {
            int prevCol = queenPositions[prevRow];

            // 같은 열에 놓인 퀸이 있는지 확인
            if (prevCol == c) {
                return false;
            }

            // 대각선에 놓인 퀸이 있는지 확인
            // 현재 행(r)과 이전 행(prevRow) 간의 거리와 열(c)과 prevCol 간의 거리가 같다면 대각선에 위치
            // x1 - x2 == y1 - y2
            if (Math.abs(r - prevRow) == Math.abs(c - prevCol)) {
                return false;
            }
        }

        // 모든 이전 행과 충돌이 없다면 현재 위치에 퀸을 놓을 수 있음
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // queenPositions 배열 초기화: 각 인덱스는 행을 의미, 값은 그 행에 놓인 퀸의 열 위치를 의미
        queenPositions = new int[n];

        // 0행부터 시작해서 각 행에 퀸을 놓는 백트래킹 시작
        placeQueen(0);

        // 모든 경우의 수 출력
        System.out.println(answer);
    }
}