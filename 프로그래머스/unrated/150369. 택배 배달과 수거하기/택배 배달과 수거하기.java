class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        for(int i = n-1; i>=0; i--){
            
            while(deliveries[i]>0 || pickups[i]>0){
                deliveries[i]-=cap;
                pickups[i]-=cap;
                answer+=(i+1)*2;
            }
            
            if(i==0) break;
            
            deliveries[i-1] += deliveries[i];
            pickups[i-1] += pickups[i];
            
        }
        
        return answer;
    }
}