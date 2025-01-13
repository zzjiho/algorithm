import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static void solution(int n, int m, int[] s1, int[] s2) {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(s1[i]);
        }

        for (int i = 0; i < m; i++) {
            int num = s2[i];
            if (hs.contains(num)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int[] s1 = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                s1[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] s2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                s2[i] = Integer.parseInt(st.nextToken());
            }

            solution(n, m, s1, s2);
        }
    }
}