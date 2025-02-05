import java.util.*;

class Solution {
    
    // 한 상자에 담으려는 귤의 개수 K
    // 귤의 크기 tangerine
    public int solution(int k, int[] tangerine) { // 6, [1,3,2,4,3,4,2,3]
        int N = tangerine.length; 
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int x : tangerine) {
            hm.put(x, hm.getOrDefault(x,0)+1);
        }
        
        ArrayList<Integer> ar = new ArrayList<>(hm.values());
        Collections.sort(ar, Collections.reverseOrder());
        
        int sum = 0;
        int answer = 0;
        for(int x : ar) {
            sum += x;
            if(sum >= k) { // 판매하고 싶은 귤 수보다 크거나 같으면                
                answer++;
                break;
            } else { 
                answer++;
            }
        }
    
        return answer;
    }
}