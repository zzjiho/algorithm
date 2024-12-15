import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void solution(int n, int[] size, int t, int p) {
        int thsirtBundles = 0;
        for (int i = 0; i < 6; i++) {
            thsirtBundles += size[i] / t;
            if (size[i] % t != 0) {
                thsirtBundles++;
            }
        }

        System.out.println(thsirtBundles);
        System.out.print(n / p + " " + n % p);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[6];
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        solution(n, size, t, p);
    }
}