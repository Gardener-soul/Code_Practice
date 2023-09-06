class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String hol = "";
        String jjak = "";
        
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                jjak+=String.valueOf(num_list[i]);
            } else{
                hol+=String.valueOf(num_list[i]);
            }
        }
        answer += Integer.parseInt(jjak) + Integer.parseInt(hol);
        return answer;
    }
}