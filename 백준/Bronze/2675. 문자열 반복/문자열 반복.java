import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void solution(int r, String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(str.charAt(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 2
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 3
            String str = st.nextToken(); // ABC
            solution(r, str);
            System.out.println();
        }
    }
}