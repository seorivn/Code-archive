class Solution {
    String[] alpha = {"A","E","I","O","U"};
    int count = 0;
    int answer = 0;
    String target;

    public int solution(String word) {
        target = word;
        dfs("");
        return answer;
    }
    
    public void dfs(String current) {
        if (current.length() > 5) return;
        if (!current.equals("")) count++;
        if (current.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(current + alpha[i]);
        }
    }
}