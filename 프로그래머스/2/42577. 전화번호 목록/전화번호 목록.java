import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, true);
        }
        
        for (String key : map.keySet()) {
            for (int i=1; i<key.length(); i++) {
                String prefix = key.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}