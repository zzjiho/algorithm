import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,s;
    static int cnt = 0;
    static int[] num;

    static void DFS(int L, int sum) {
        if (L == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        } else {
            DFS(L + 1, sum + num[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0,0);

        // 문제에서, '크기가 양수인 부분수열' 이라고 했으니
        // 적어도 하나 이상의 원소를 포함하고 있어야함
        // 즉, 공집합은 빼줘야한다
        if (s == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }
}