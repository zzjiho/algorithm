import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> ar = new ArrayList<>();
        int sum = 0;

        // m 이상 n 이하 완전 제곱수 모두 찾기
        for (int i = m; i <= n; i++) {
            int k = (int) Math.sqrt(i);

            if (k * k == i) {
                ar.add(i);
                sum += i;
            }
        }

        if (ar.isEmpty()) {
            System.out.print(-1);
        } else {
            System.out.println(sum);
            System.out.print(ar.get(0));
        }
    }
}