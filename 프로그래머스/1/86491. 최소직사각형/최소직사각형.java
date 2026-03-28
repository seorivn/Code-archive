class Solution {
    public int solution(int[][] sizes) {
        int mw = 0; 
        int mh = 0;
        
        for (int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            
            if (w > h) {
                mw = Math.max(mw, w);
                mh = Math.max(mh, h);
            } else {
                mw = Math.max(mw, h);
                mh = Math.max(mh, w);
            }
        }
        return mw*mh;
    }
}