import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0; 
        int N = 10; // 회원 자격 기간
        
        // 원하는 상품 담을 map
        Map<String, Integer> wmap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wmap.put(want[i], number[i]);
        } 
       
        // 연속 10일 구간 검사
        for (int i = 0; i < discount.length - N + 1; i++) {
            // 할인 제품 담을 map
            Map<String, Integer> dmap = new HashMap<>();
            
            for (int j = 0; j < N; j++) {
                dmap.put(discount[i + j], dmap.getOrDefault(discount[i + j], 0) + 1);
            }
            
            Boolean flag = true;
            
            // 정현이가 원하는 각 제품에 대해 비교 수행
            for (String key : wmap.keySet()) {
                if (wmap.get(key) != dmap.get(key)) {
                    flag = false;
                    break; // 하나라도 다르면 필요가 없어짐
                }
            }
            
            if(flag) {
                answer++;
            }
        }
        
        return answer;
    }
}