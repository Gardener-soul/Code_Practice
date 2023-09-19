class Solution {
    public int[] solution(int[] arr) {
        int[] num = {1,2,4,8,16,32,64,128,256,512,1024};
        int n = arr.length;
        int i = 0;
        for(i=0; i<num.length; i++){
            if(n<=num[i]){
                break;
            }
        }
        
        int[] answer = new int[(int)Math.pow(2,i)];
        for(int j=0; j<n; j++){
            answer[j] = arr[j];
        }
        return answer;
    }
}