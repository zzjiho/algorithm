import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int L) {
        if (L == m) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) { // 방문하지 않은것만
                    visited[i] = true;
                    answer[L] = i;
                    DFS(L + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 

        answer = new int[m];
        visited = new boolean[n+1];

        DFS(0);
        System.out.println(sb);
    }
}