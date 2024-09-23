
class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] str = {"A","E","I","O","U"};
        String tmp = "";
        
        for(int a=0; a<5; a++) {
            tmp = str[a];
            answer++;
            if(word.equals(tmp)) return answer;
            
            for(int b=0; b<5; b++) {
                tmp = str[a] + str[b];
                answer++;
                if(word.equals(tmp)) return answer;
                
                for(int c=0; c<5; c++) {
                    tmp = str[a] + str[b] + str[c];
                    answer++;
                    if(word.equals(tmp)) return answer;
                    
                    for(int d=0; d<5; d++) {
                        tmp = str[a] + str[b] + str[c] + str[d];
                        answer++;
                        if(word.equals(tmp)) return answer;
                    
                        for(int e=0; e<5; e++) {
                            tmp = str[a] + str[b] + str[c] + str[d] + str[e];
                            answer++;
                            if(word.equals(tmp)) return answer;
                        }
                    }
                }
            }
        }
        return answer;
    }        
}