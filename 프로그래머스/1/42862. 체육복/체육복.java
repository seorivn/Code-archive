import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        /* 초기 세팅 */
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int l : lost) lostList.add(l);
        for (int r : reserve) reserveList.add(r);
        
        List<Integer> both = new ArrayList<>();
        // 잃어버렸는데 여벌 가져옴
        for (int l : lostList) {
            if (reserveList.contains(l)) {
                both.add(l);
            }
        }
        lostList.removeAll(both);
        reserveList.removeAll(both);
            
        Collections.sort(lostList);
        Collections.sort(reserveList);
        
        /* 빌려주기 */
        for (int r : reserveList) {
            if (lostList.contains(r-1)) {
                lostList.remove(Integer.valueOf(r-1)); // Java remove 값으로 지울때
            } else if (lostList.contains(r+1)) {
                lostList.remove(Integer.valueOf(r+1));
            }
        }
        return n - lostList.size();
    }
}