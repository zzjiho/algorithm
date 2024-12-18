import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static void solution(HashMap<Integer, Integer> hm1, int[] ar) {
        for (int x : ar) {
            if (hm1.containsKey(x)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> hm1 = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            hm1.put(num, hm1.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        int[] ar = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        solution(hm1, ar);
    }
}