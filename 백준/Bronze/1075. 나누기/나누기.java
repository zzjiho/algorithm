import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void solution(int n, int f) {
        int result = 0;
        int num = n - (n % 100);

        for (int i = 0; i < 100; i++) {
            int x = num + i;
            if (x % f == 0) {
                result = i;
                break;
            }
        }

        System.out.printf("%02d", result);
    }

    // O(1): 상수시간 인데 ,
    // 이건 데이터 원소가 N개와 상관없이 항상 일정한 상수 갯수의 단계 수만 걸리는 알고리즘.
    // 즉 데이터 증가에 영향을 받지 않는 알고리즘이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        solution(n, f);
    }
}