import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int answer;

    static void DFS(int sum) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            answer++;
            return;
        } else {
            for (int i = 1; i <= 3; i++) {
                DFS(sum + i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            answer = 0;
            DFS(0);
            System.out.println(answer);
        }
    }
}