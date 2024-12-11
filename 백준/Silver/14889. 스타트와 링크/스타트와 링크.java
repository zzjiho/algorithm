import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 스타트팀, 링크팀으로 인원을 반반 나눈다.
 * 조합을 이용해서 인원을 나누는데, 방문배열을 이용하여 나눔
 * 즉, n/2명이 방문배열에 체크되면 스타트팀, 체크 안되면 링크팀으로 나눈다.
 * 
 * 2. 그렇게 나눈 인원들을 루프 돌면서 두 팀의 능력치의 합을 구하고
 * 
 * 3. 두 팀의 능력치 차이가 최소가 되는값을 찾으면 됨.
 */
public class Main {

    static int n;
    static int[][] board;
    static boolean[] visited; // 각 사람이 스타트 팀에 속하는지 여부
    static int answer = Integer.MAX_VALUE;

    // 팀 인원 모두 정했을시 능력치 차이 계산
    static void calcStat() {
        int startSum = 0; // 스타트팀 능력치 합
        int linkSum = 0; // 링크팀 능력치 합

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 두 사람 모두 스타트 팀이면
                if (visited[i] && visited[j]) {
                    startSum += board[i][j] + board[j][i];
                } else if (!visited[i] && !visited[j]) { // 링크팀이면
                    linkSum += board[i][j] + board[j][i];
                }
            }
        }

        // 두 팀 능력치 차이가 최소가 되는값 찾기
        answer = Math.min(answer, Math.abs(startSum - linkSum));
    }

    static void DFS(int s, int count) {
        // N/2명 선택 완료시 능력치 차이 계산
        if (count == n / 2) {
            calcStat();
            return;
        } else {
            for (int i = s; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(i + 1, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0번부터 시작해서 팀 나누기 시작
        DFS(0, 0);
        System.out.println(answer);
    }
}