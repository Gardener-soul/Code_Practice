import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sarr = s.split("");
        int cnt = 0;
        
        Arrays.sort(sarr);
        
        for (int i=0; i<sarr.length; i++){
            cnt = 0;
            for (int j=0; j<sarr.length;j++){
                if(sarr[i].equals(sarr[j])){
                    cnt+=1;
                }
            }
            if (cnt==1){
                answer+=sarr[i];
            }
        }
        return answer;
    }
}