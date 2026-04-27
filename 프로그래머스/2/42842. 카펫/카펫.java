class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;

        for (int h = 1; h <= Math.sqrt(total); h++) {
            if (total % h == 0) {
                int w = total / h;
                
                if ((w-2) * (h-2) == yellow) {
                    return new int[]{w,h};
                }
            }
        }
        return answer;
    }
}