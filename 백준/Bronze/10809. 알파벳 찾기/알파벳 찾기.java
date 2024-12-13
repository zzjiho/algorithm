import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void solution(String str) {
        int[] alpha = new int[26];
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 97; // idx = 98-97 = 1 , 즉 b는 1이 된다.
            if (alpha[idx] == -1) { // 원소가 -1 일때 초기화를 해야 같은 알파벳이 들어가도 앞에것을 우선으로 
                alpha[idx] = i;
            }
        }

        for (int x : alpha) {
            System.out.print(x + " ");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution(str);
    }
}