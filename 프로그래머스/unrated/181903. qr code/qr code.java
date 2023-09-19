class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        String[] co = code.split("");
        for(int i=0; i<co.length; i++){
            if(i%q==r){
                answer+=co[i];
            }
        }
        return answer;
    }
}