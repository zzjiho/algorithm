import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] board = new String[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = "W";
                } else {
                    board[i][j] = "B";
                }
            }
        }

        int min = 64;

        // n=10, m=13 이라면
        // 밑으로 3번, 오른쪽으로 6번 이동하면서 8X8 배열 만들 수 있음.
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                min = Math.min(min, cal(i, j, board));
            }
        }
        System.out.println(min);
    }

    static int cal(int x, int y, String[][] WB) {
        int count = 0;

        String color = "W"; // 첫번째 칸을 W를 기준으로 색칠

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (!WB[i][j].equals(color)) {
                    count++;
                }

                if (color.equals("W")) { // 컬러 변경
                    color = "B";
                } else {
                    color = "W";
                }
            }

            if (color.equals("W")) { // 행 바뀌면 바로 윗칸과 색이 달라야함
                color = "B";
            } else {
                color = "W";
            }
        }
        
        count = Math.min(count, 64 - count);
        return count;
    }
}