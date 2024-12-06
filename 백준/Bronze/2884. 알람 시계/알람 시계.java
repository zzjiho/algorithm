import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static void solution(int h, int m) {

        if (h == 0) { // 0시 일때
            if (m < 45) { // 이면서 45분 이하이면
                h = 23;
                m = 60-45+m;
            } else { // 이면서 45분 이상이면
                m = m - 45;
            }
        } else if (h > 0) { // 0시 초과이고
            if (m < 45) { // 45분 이하이면
                h--;
                m = 60 - 45 + m;
            } else {
                m = m - 45;
            }
        }

        sb.append(h).append(' ').append(m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(h, m);
        System.out.println(sb);
    }
}