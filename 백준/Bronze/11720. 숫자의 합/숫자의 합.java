import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void solution(int n, String str) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += str.charAt(i) - '0';
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        String str = br.readLine();

        solution(n, str);
    }
}