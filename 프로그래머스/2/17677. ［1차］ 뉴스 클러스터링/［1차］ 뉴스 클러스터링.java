import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            if(tmp.matches("[A-Z]{2}")) {
                map1.put(tmp, map1.getOrDefault(tmp, 0) + 1);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            if(tmp.matches("[A-Z]{2}")) {
                map2.put(tmp, map2.getOrDefault(tmp, 0) + 1);
            }
        }
        
        int intersection = 0;
        int union = 0;
        
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
            union += Math.max(map1.get(key), map2.getOrDefault(key, 0));
        }
        
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }
        
        if(union == 0) return 65536;
        
        double jaccard = (double) intersection / union;
        return (int) (jaccard * 65536);
    }
}
