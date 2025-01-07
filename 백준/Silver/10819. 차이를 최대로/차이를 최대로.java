import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int answer = Integer.MIN_VALUE;
    static int[] ar, newAr;
    static boolean[] visited;

    static void dfs(int L) {
        int sum = 0;
        if (L == n) {
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(newAr[i] - newAr[i + 1]);
            }
            answer = Math.max(answer, sum);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                // 방문 안했으면
                if (!visited[i]) {
                    visited[i] = true;
                    newAr[L] = ar[i];
                    dfs(L+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ar = new int[n];
        newAr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.print(answer);
    }
}
