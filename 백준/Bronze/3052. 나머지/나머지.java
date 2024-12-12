import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
/**
 * HashSet<E>:
 * 오직 Value(요소)만을 저장하며, 모든 원소가 유일(unique)해야 하는 집합 구조.
 * 중복을 허용하지 않으므로, 삽입 시 이미 존재하는 요소라면 추가되지 않는다.
 * 어떤 값의 존재 여부나 유일한 값들의 개수를 파악하고자 할 때 유용
 */
public class Main {

    static int solution(int[] ar) {
        HashSet<Integer> hs = new HashSet<>();

        for (int x : ar) {
            hs.add(x % 42);
        }

        return hs.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ar = new int[10];

        for (int i = 0; i < 10; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(ar));
    }
}