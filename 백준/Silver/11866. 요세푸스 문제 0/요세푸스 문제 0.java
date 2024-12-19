import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static StringBuilder sb = new StringBuilder();

    static void solution(Queue<Integer> Q) {
        sb.append("<");
        while (!Q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                Q.offer(Q.poll());
            }
            sb.append(Q.poll());
            if (!Q.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> Q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        solution(Q);
    }
}