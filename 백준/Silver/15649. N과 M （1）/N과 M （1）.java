import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] pm;
    static boolean[] ch;

    static void DFS(int L) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    pm[L] = i;
                    DFS(L + 1);
                    ch[i] = false; // 방문 해제 (백트래킹)
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        ch = new boolean[n + 1];

        DFS(0);
    }
}