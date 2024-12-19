import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> Q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int m = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                m = Integer.parseInt(st.nextToken());
                Q.offer(m);
            } else if (str.equals("pop")) {
                if (Q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(Q.poll()).append("\n");
                }
            } else if (str.equals("size")) {
                sb.append(Q.size()).append("\n");
            } else if (str.equals("empty")) {
                if (Q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (str.equals("front")) {
                if (Q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(Q.peek()).append("\n");
                }
            } else if (str.equals("back")) {
                if (Q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(m).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}