import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board = new int[9][9];
    static boolean flag = false;

    static void DFS(int row, int col) {
        // 모든 행 다 채우면
        if (row == 9) {
            printBoard();
            flag = true;
            return;
        }

        int nextRow = row;
        int nextCol = col +1;
        // 한 행에서 모든 열 다 탐색시 재세팅
        if (nextCol == 9) {
            nextRow = row+1;
            nextCol = 0;
        }

        // board가 0 이면 1~9 숫자가 들어갈수 있는지 체크해서 넣어줘야함.
        if (board[row][col] != 0) {
            DFS(nextRow, nextCol);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (check(row, col, num)) {
                    board[row][col] = num;
                    DFS(nextRow, nextCol);
                    if (flag) return;
                    board[row][col] = 0;
                }
            }
        }
    }

    // 행, 열, 3X3 박스에 중복되는 숫자 있는지 체크
    static boolean check(int row, int col, int num) {
        // 행열 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }

            if (board[i][col] == num) {
                return false;
            }
        }

        // 3X3 검사
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        DFS(0, 0);
    }
}