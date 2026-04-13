import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                prev = stack.pop();
                answer[prev] = i - prev;
            }

            stack.push(i);
        }
        // 주식 가격 안떨어짐
        while (!stack.isEmpty()) {
            prev = stack.pop();
            answer[prev] = prices.length - prev - 1;
        }
        return answer;
    }
}
