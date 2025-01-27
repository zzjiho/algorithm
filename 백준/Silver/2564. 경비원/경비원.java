import java.io.*;
import java.util.*;

public class Main {

    static int width, height;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken()); // 가로 10
        height = Integer.parseInt(st.nextToken()); // 세로 5
        int N = Integer.parseInt(br.readLine()); // 상점 수 3

        int spots[] = new int[N+1]; // 상점 수 + 동근이 위치
        int total = (width+height) * 2; // 30

        for(int i=0; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 1 3 2 2
            int dis  = Integer.parseInt(st.nextToken()); // 4 2 8 3
            int pos = 0;

            if(dir == 1) { // 1북
                pos = dis;
            } else if(dir == 2) { // 2남
                pos =  width + height + (width-dis);
            } else if(dir == 3) { // 3서
                pos =  width + height + width + (height-dis);
            } else if(dir == 4) { // 4동
                pos =  width + dis;
            }
            spots[i] = pos;
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            // (시계방향)동근이 거리로부터 각 상점 거리 = 동근 거리 - 각 상점 거리
            int len = Math.abs(spots[N] - spots[i]);
            // min((반시계 방향 거리) , (시계 방향 거리))
            answer += Math.min(total-len, len);
        }

        System.out.println(answer);
    }
}