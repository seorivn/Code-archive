import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        int[] dxs = {-1, 1, 0, 0};
        int[] dys = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][m];
        
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int d=0; d<4; d++) {
                int nx = x+dxs[d];
                int ny = y+dys[d];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[x][y] + 1;
                }
            }
        }
        return maps[n-1][m-1] < 2 ? -1 : maps[n-1][m-1];
    }
}