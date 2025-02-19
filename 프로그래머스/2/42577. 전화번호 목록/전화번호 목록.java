import java.util.*;

class Solution {
    public boolean solution(String[] p) {
        // 배열을 사전순으로 정렬
        Arrays.sort(p);
        
        // 인접한 번호끼리만 비교
        for (int i = 0; i < p.length - 1; i++) {
            if (p[i+1].startsWith(p[i])) {
                return false;
            }
        }
        return true;
    }
}