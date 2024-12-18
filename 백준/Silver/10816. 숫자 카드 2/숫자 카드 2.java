import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static void solution(HashMap<Integer, Integer> hm, int[] ar) {
        StringBuilder sb = new StringBuilder();

        for (int x : ar) {
            if (hm.get(x) == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(hm.get(x)).append(" ");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        int[] ar = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        solution(hm,ar);
    }
}