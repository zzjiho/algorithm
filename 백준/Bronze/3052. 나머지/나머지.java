import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int solution(int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            int n = ar[i] % 42;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return map.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ar = new int[10];

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ar[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(ar));
    }
}