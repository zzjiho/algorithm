import java.util.*;

class Solution {
    // 각 종류별로 최대 1가지 의상 착용 가능
    // 서로 다른 옷의 조합의 수 return
    public int solution(String[][] clothes) { // ["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"]
        
        HashMap<String,Integer> hm = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1]; // eyewear
            hm.put(type, hm.getOrDefault(type, 0) + 1); // 종류별로 몇개의 옷만 있는지 알면 답 구할 수 있음
        }
        
        // 각 종류별 (해당 종류의 이상 수 + 1)을 곱함
          // +1은 해당 종류의 의상을 선택하지 않는 경우를 의미
        int cnt = 1;
        for (int num : hm.values()) {
            cnt *= (num + 1);
        }
        
        // 아무것도 입지 않는 경우 1 가지 빼기
        return cnt - 1;
    }
}