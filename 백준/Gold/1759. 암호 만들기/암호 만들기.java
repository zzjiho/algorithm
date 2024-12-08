import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 오름차순으로 조합구하기 같음.
public class Main {

    static int L;
    static int C;
    static String alphabet[];
    static String answer[];
    static StringBuilder sb = new StringBuilder();

    static void DFS(int depth, int s) {
        if (depth == L) {
            int moCount = 0;
            int jaCount = 0;

            // 최소 한개의 모음, 최소 두개의 자음으로 배치가 되었는지 ?
            // 되었으면 출력, 아니면 return
            for (int i = 0; i < L; i++) {
                char c = answer[i].charAt(0);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    moCount++;
                } else {
                    jaCount++;
                }
            }

            if (moCount >= 1 && jaCount >= 2) {
                sb.append(String.join("", answer)).append("\n");
            }
            return;

        } else {
            for (int i = s; i < C; i++) {
                answer[depth] = alphabet[i];
                DFS(depth + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 4
        C = Integer.parseInt(st.nextToken()); // 6

        alphabet = new String[C];
        answer = new String[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken(); // a t c i s w
        }

        Arrays.sort(alphabet); // 사전직으로 나열

        DFS(0, 0);
        System.out.println(sb.toString());
    }
}