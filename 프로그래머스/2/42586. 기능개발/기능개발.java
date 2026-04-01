import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        
        for (int i=0; i<progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            days[i] = day;
        }
        int count = 1;
        List<Integer> list = new ArrayList<>();
        int current = days[0];
        for (int i=1; i<days.length; i++) {
            if (current >= days[i]) {
                count++;
            } else {
                list.add(count);
                count = 1;
                current = days[i];
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
