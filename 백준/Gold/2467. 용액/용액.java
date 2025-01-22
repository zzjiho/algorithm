import java.io.*;
import java.util.*;

public class Main {

    // now인 현재 선택한 용액 하나를 구하고서
    //나머지 요소들에서 이분탐색하면서 구한 값을
    //now랑 더해주면서 0이랑 가장 가까운 조합을 찾는 로직
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long liquid = Integer.MAX_VALUE; 
        int x = 0, y = 0;  // 결과값을 저장할 변수

        // 각 용액에 대해 이분탐색 수행
        for(int i = 0; i < N-1; i++) { // 마지막 원소는 자기 자신 이후에 비교할 다른 용액이 없기 때문에 n-1 까지
            int now = arr[i];  // 현재 선택한 용액
            int lt = i + 1;  // 현재 용액 다음부터 시작
            int rt = N - 1;    // 배열의 끝까지

            // 이분탐색으로 가장 0에 가까운 조합 찾기
            while(lt <= rt) {
                int mid = (lt + rt) / 2; 
                // 현재 용액 + 탐색해서 찾은 용액 
                long nowLiquid = (long)now + arr[mid];

                // 현재 조합이 기존 답보다 0에 더 가까운 경우
                // 0에 가장 가까운 용액을 찾는 것이므로 절대값으로 계산
                if(Math.abs(nowLiquid) < liquid) {
                    liquid = Math.abs(nowLiquid); 
                    x = now;            // 첫 번째 용액 저장 
                    y = arr[mid];       // 두 번째 용액 저장
                }

                // 두 용액의 합이 음수면 더 큰 값을 찾기 위해 오른쪽으로
                if(nowLiquid < 0) {
                    lt = mid + 1;
                }
                // 두 용액의 합이 양수면 더 작은 값을 찾기 위해 왼쪽으로
                else {
                    rt = mid - 1;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}