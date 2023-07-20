class Solution {
    public String solution(String rsp) {
        String[] sarr = rsp.split("");
        String answer = "";
        for(int i=0; i<sarr.length; i++){
            if(sarr[i].equals("2")){
                answer+="0";
            } else if (sarr[i].equals("0")){
                answer+="5";
            } else answer+="2";
        }
        return answer;
    }
}