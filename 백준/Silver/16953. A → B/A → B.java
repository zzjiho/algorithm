import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long a, b;
    static int cnt;

    static int BFS() {
        Queue<Long> Q = new LinkedList<>();
        Q.offer(a);

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) { // 레벨 별로 탐색해야 해서 for문 돈다
                long tmp = Q.poll();

                if (tmp == b) {
                    return cnt+1;
                }

                if (tmp * 2 <= b) {
                    Q.add(tmp * 2);
                }

                if (tmp * 10 + 1 <= b) {
                    Q.add(tmp * 10 + 1);
                }
            }
            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        System.out.println(BFS());
    }
}