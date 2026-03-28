import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 값 초기화
        int[] score = {0, 0, 0, 0}; 
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == a1[i % a1.length]) score[1]++;
            if (answers[i] == a2[i % a2.length]) score[2]++;
            if (answers[i] == a3[i % a3.length]) score[3]++;
        }
        
        // 최대값
        int maxV = Math.max(score[1], Math.max(score[2], score[3]));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<4; i++) {
            if (score[i] == maxV) list.add(i);
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}