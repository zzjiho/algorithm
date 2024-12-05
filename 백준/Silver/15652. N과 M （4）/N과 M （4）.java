import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int L, int s) {
        if (L == m) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = s; i <= n; i++) {
                    answer[L] = i;
                    DFS(L + 1, i);
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

        DFS(0,1);
        System.out.println(sb);
    }
}