import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static String solution(int[] ar) {
        int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] desc = {8, 7, 6, 5, 4, 3, 2, 1};

        if (Arrays.equals(ar, asc)) {
            return "ascending";
        } else if (Arrays.equals(ar, desc)) {
            return "descending";
        }

        return "mixed";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ar = new int[8];

        for (int i = 0; i < 8; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(ar));
    }
}