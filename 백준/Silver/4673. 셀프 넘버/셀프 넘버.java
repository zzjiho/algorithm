public class Main {

    static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        StringBuilder sb = new StringBuilder();

        // 생성자 있는 수 체크
        for (int i = 1; i <= 10000; i++) {
            int num = d(i);
            if (num <= 10000) {
                check[num] = true;
            }
        }

        // 생성자 없는 수 출력
        for (int i = 1; i <= 10000; i++) {
            if (!check[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}