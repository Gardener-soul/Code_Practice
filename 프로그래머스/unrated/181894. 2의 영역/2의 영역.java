class Solution {
    public int[] solution(int[] arr) {
        
        int max = 0;
        int min = 100001;
        
        for(int i=0; i<arr.length;i++){
            if(arr[i]==2){
                min = Math.min(min,i);
                max = Math.max(max,i);
            }
        }
        
        if(min-max==100001){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        } else{
            int[] answer = new int[max-min+1];
            int idx = 0;
            for(int i=min; i<=max; i++){
                answer[idx++] = arr[i];
            }
            return answer;
        }
    }
}