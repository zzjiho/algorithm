import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void print(int[] ar) {
        for (int x : ar) {
            System.out.println(x);
        }
    }

    static void solution(String num) {
        int[] ar = new int[10];
        for (int i = 0; i < num.length(); i++) { // 17037300
            int idx = num.charAt(i) - '0';
            ar[idx]++;
        }

        print(ar);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String num = String.valueOf(a * b * c);

        solution(num);
    }
}