import java.io.*;
import java.util.*;

public class Main {

    static int N,W,L;
    static Queue<Integer> bridge, truck;

    static void solution() {

        // 아무것도 다리에 안올라왔을때 0 넣어서 빈칸을 표현
        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        int weightBridge = 0; // 다리 위 트럭 무게
        int time =0; // 흐르는 시간

        // 다리에 들어있는 요소(트럭 무게)가 전부 빠져나갈때 때까지 반복
        while (!bridge.isEmpty()) {
            time++;

            // 1초 지날때마다 맨 앞의 트럭을 다리에서 꺼낸다
            weightBridge -= bridge.poll();

            // 더 이상 대기 트럭이 없으면 뒤 로직을 진행하지 않고 반복
            if (truck.isEmpty()) {
                continue;
            }

            // 다음 트럭이 올라갈 수 있는지 확인 (현재 무게 + 대기 트럭의 무게 <= 최대 하중)
            if (weightBridge + truck.peek() <= L) {
                // 올라갈 수 있으면 트럭 하나 꺼내서 다리에 진입
                int tmp = truck.poll();
                weightBridge += tmp;
                bridge.offer(tmp);
            } else {
                // 아직 무게 제한을 넘어서면 트럭 대신 0을 넣어 한 칸 이동만 시킴
                bridge.offer(0);
            }
        }

        System.out.println(time);
    }

    // 다리 건너는 최단시간은?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 4 (트럭 수)
        W = Integer.parseInt(st.nextToken()); // 2 (다리 길이)
        L = Integer.parseInt(st.nextToken()); // 10 (다리 최대 하중)

        bridge = new LinkedList<>();
        truck = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        solution();
    }
}