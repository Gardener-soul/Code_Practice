import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        ArrayList<Integer> arr = new ArrayList<>();
        int maxa = 0;
        int maxb = 0;
        int tmpMin = 1001;
        
        for(int i=0; i<sizes.length; i++){
            maxa = Math.max(maxa,(Math.max(sizes[i][0], sizes[i][1])));
        }
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] == maxa || sizes[i][1] == maxa){
                if(maxa==sizes[i][0]) arr.add(sizes[i][1]);
                else arr.add(sizes[i][0]);
            }
        }
        
        for(int i=0; i<arr.size(); i++) {
            tmpMin = Math.min(tmpMin, arr.get(i));
        }
        
        for(int i=0; i<sizes.length; i++){
            int tmp = 0;
            tmp = Math.min(sizes[i][0], sizes[i][1]);
            maxb = Math.max(tmp,maxb);
        }
        
        return maxa * maxb;
    }
}