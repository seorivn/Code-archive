import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clist : clothes) {
            map.put(clist[1], map.getOrDefault(clist[1], 0) + 1);
        }
        
        int answer = 1;
        for (int num : map.values()) {
            answer *= (num+1);
        }
        return answer - 1;
    }
}