import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person {
    int weight, height;

    Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class Main {

    static int[] solution(ArrayList<Person> ar, int n) {
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (i==j) continue; // 자기자신 비교X
                if (ar.get(i).weight < ar.get(j).weight &&
                        ar.get(i).height < ar.get(j).height) {
                    cnt++;
                }
            }
            rank[i] = cnt;
        }
        return rank;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Person> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            ar.add(new Person(w, h));
        }

        StringBuilder sb = new StringBuilder();
        for (int x : solution(ar, n)) {
            sb.append(x + " ");
        }
        System.out.println(sb);
    }
}