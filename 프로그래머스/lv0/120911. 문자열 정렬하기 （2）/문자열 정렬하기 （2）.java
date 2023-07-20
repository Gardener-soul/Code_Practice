import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        String[] my_s = my_string.split("");
        Arrays.sort(my_s);
    
        for(int i=0; i<my_s.length; i++){
            answer+=my_s[i];
        } 
        return answer;
    }
}