import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int N = my_string.length();
        String[] answer = new String[N];
        for(int i = 0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<N; j++){
                sb.append(my_string.charAt(j));    
            }
            answer[i] = sb.toString();
        }
        Arrays.sort(answer);
        return answer;
    }
}