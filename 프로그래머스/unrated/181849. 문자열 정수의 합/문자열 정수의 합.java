class Solution {
    public int solution(String num_str) {
        int answer = 0;
        int[] num = new int[num_str.length()];
        String[] sarr = num_str.split("");
        
        for(int i=0; i<num.length; i++){
            num[i] = Integer.parseInt(sarr[i]);
        }
        for(int i=0; i<num.length; i++){
            answer+=num[i];
        }
        return answer;
    }
}