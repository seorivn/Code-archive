import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited);

        for (int num : set) {
            if (prime(num)) answer++;
        }
        
        return answer;
    }
    
     public static boolean prime(int num) {
        if(num < 2) return false;
        if(num == 2) return true;
         
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
         
        return true;
    }
    
    public void dfs(String current, String numbers, boolean[] visited) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current+numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
}

