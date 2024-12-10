import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] ar; // 1 7 8 9
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int L, int s) {
        if (L == m) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            sb.append("\n");
        } else {
            for (int i = s; i < n; i++) {
                answer[L] = ar[i];
                DFS(L + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 4
        m = Integer.parseInt(st.nextToken()); // 2
        ar = new int[n];
        answer = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken()); // 9 8 7 1
        }
        Arrays.sort(ar);

        DFS(0, 0);
        System.out.println(sb.toString());
    }
}