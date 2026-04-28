class Solution {
    int maxValue = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return maxValue;
    }
    
    public void dfs(int fatigue, int[][] dungeons, boolean[] visited, int count) {
        maxValue = Math.max(maxValue, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(fatigue-dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false;
            }
        }
    }
}