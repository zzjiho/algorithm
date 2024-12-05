import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] answer;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int L, int s) { // (0,0)
        if (L == m) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        } else {
            for (int i = s; i < n; i++) {
                    answer[L] = num[i];
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
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        DFS(0, 0);
        System.out.println(sb);
    }
}