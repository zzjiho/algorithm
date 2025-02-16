import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        // 입력값 자르기
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] ar = s.split("-");
        
        // 길이순서대로 오름차순 정렬
        Arrays.sort(ar, (a,b) -> a.length() - b.length());
        
        // 방문하지 않은 원소를 순서대로 추가
        ArrayList<Integer> answer = new ArrayList<>();
        for(String x : ar) { // 2    2,1     1,2,3   1,2,4,3
            for(String y : x.split(",")) {
                int num = Integer.parseInt(y);
                if(!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        
        return answer;
    }
}