import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for (int i=0; i<n; i++) {
            int H = n-i;
            if (citations[i] >= H) {
                return H;
            }
        }
        
        return 0;
    }
}
