import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> newScoville = new PriorityQueue<>();
        for (int s : scoville) {
            newScoville.offer(s);
        }
        
        int count = 0;
        while (newScoville.peek() < K) {
            if (newScoville.size() < 2) return -1;
            
            int frist = newScoville.poll();
            int second = newScoville.poll();
            
            newScoville.offer(frist + (second * 2));
            count++;
        }
        
        return count;
    }
}