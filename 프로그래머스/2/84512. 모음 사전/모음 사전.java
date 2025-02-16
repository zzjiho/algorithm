import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    char[] ar = {'A','E','I','O','U'};
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word) + 1; // w의 인덱스를 찾아 +1 (사전에서 몇 번째인지)
    }
    
    public void dfs(String s, int L) {
        if(L == 5) return; 
        
        for(char c : ar){
            String word = s + c;
            list.add(word);
            dfs(word, L + 1);
        }
    }
}