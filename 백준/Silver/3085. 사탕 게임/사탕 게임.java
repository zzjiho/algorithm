import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] board;

    static int solution() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽 사탕이랑 바꿨을때
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);
                    int count = count();
                    answer = Math.max(count, answer);
                    swap(i, j + 1, i, j); // 다시 원래대로
                }

                // 아래쪽 사탕이랑 바꿨을때
                if (i + 1 < n) {
                    swap(i, j, i + 1, j);
                    int count = count();
                    answer = Math.max(count, answer);
                    swap(i + 1, j, i, j);
                }
            }
        }
        return answer;
    }

    static void swap(int i, int j, int k, int l) {
        char tmp = board[i][j]; // 'C'
        board[i][j] = board[k][l];
        board[k][l] = tmp;
    }

    static int count() {
        int result = 0;
        // 행에서 연속된 사탕 개수 찾기
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n-1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                   cnt++;
                } else {
                    cnt = 1;
                }
                result = Math.max(result, cnt);
            }
        }

        // 열에서 연속된 사탕 개수 찾기
        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 0; i < n-1; i++) {
                if (board[i][j] == board[i + 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                result = Math.max(result, cnt);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        System.out.print(solution());
    }
}