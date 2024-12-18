import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static void solution(Queue<Integer> Q) {

        while (Q.size() != 1) {
            Q.poll();
            Integer peek = Q.peek();
            Q.offer(peek);
            Q.poll();
        }

        System.out.println(Q.peek());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> Q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        solution(Q);
    }
}