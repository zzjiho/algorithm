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
        int b = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int h = 0; h <= 256; h++) {
            int removedBlock = 0;
            int addedBlock = 0;
            int time = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > h) { // 땅의 높이가 h보다 크면
                        // 땅에 블럭을 깎아야겠지 ?
                        removedBlock += board[i][j] - h;
                    } else {
                        // 땅에 블럭을 채워야겠지 ?
                        addedBlock += h - board[i][j];
                    }
                }
            }

            if (b + removedBlock >= addedBlock) {
                // 그래야지 내가 갖고있는 블럭에서 처리 할 수 있겠지 ?
                time = 2 * removedBlock + addedBlock;

                if (minTime > time) {
                    minTime = time;
                    resultHeight = h;
                } else if(time == minTime && h > resultHeight) { // 동일한 시간이지만 더 높은 높이인 경우
                    resultHeight = h;  
                }
            }
        }

        System.out.print(minTime + " " + resultHeight);
    }
}