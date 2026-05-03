class Solution {
    public int solution(String name) {
        int count = 0;
        int n = name.length();
        
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            count += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int move = n - 1; // 한 방향으로만 갔을 때
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            while (next < n && name.charAt(next) == 'A') {
                next++; 
            }
            move = Math.min(move, i * 2 + (n - next)); // 앞으로 갔다가 뒤로
            move = Math.min(move, (n - next) * 2 + i); // 뒤로 갔다가 앞으로
        }
        
        return count + move;
    }
}