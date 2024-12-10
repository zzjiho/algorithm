import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m; 
    static int[] ar; 
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int L) {
        if (L == m) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        } else {
            int lastUsed = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    if (ar[i] == lastUsed) {
                        continue;
                    }
                    visited[i] = true;
                    answer[L] = ar[i];
                    lastUsed = ar[i];
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
        ar = new int[n];
        answer = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ar);

        DFS(0);
        System.out.println(sb.toString());
    }
}