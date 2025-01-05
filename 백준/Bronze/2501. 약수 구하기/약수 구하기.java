import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 

        ArrayList<Integer> ar = new ArrayList<>();

        // n 의 약수들을 구하기
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ar.add(i);
            }
        }

        // n 의 약수에서 k번째 수 구하기
        if (k <= ar.size()) {
            System.out.println(ar.get(k-1));
        } else{
            System.out.println(0);
        }
    }
}