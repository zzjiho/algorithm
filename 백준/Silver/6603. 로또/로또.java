import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int k;
    static int[] s;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int L, int start) {
        if (L == 6) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        } else {
            for (int i = start; i < k; i++) {
                answer[L] = s[i];
                DFS(L + 1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            s = new int[k];
            answer = new int[6];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            sb.setLength(0); // StringBuilder 초기화
            DFS(0, 0);
            System.out.println(sb);
        }
    }
}