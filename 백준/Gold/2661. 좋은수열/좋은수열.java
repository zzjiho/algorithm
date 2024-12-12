import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean flag = false;

    static void DFS(String seq) {
        /**
         * 헷갈려서 정리 :
         * flag를 전역으로 관리하기때문에 true가 되면
         * 모든 상위 스택 프레임에서도 found로 설정이 되므로,
         * 더 이상 처리를 진행하지 않고 모두 반환한다.
         *
         * 즉, 최초 정답을 찾은 시점 이후로는 재귀 호출 스택을 전부 정리하며 main 으로 돌아오게 되며 DFS의 완전탐색이 종료됨
         */
        if (flag) return;

        // 길이가 N이면서 좋은 수열이면 탐색 종료
        if (seq.length() == n) {
            System.out.println(seq);
            flag = true;
            return;
        } else {
            for (int i = 1; i <= 3; i++) {
                String newSeq = seq + i;
                if (isGood(newSeq)) {
                    DFS(newSeq);
                }
            }
        }
    }

    // 좋은수열인지 판단하는 메소드
    static boolean isGood(String seq) {
        int len = seq.length();

        // 뒤에서 i길이 부분수열과 그 바로 앞에부터 i길이 부분수열 비교
        for (int i = 1; i <= len / 2; i++) {
            String end1 = seq.substring(len - i);
            String end2 = seq.substring(len - 2 * i, len - i);

            // 나쁜수열이면
            if (end1.equals(end2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 7

        DFS("");
    }
}
