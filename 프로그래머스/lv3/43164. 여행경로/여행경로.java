import java.util.*;

class Solution {
    
    static boolean[] chk;
    static PriorityQueue<String> pq = new PriorityQueue<>();
    
    public static void dfs(String[][] tickets, int level, String start, String to){
        
        if(level == tickets.length){
            pq.offer(to);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!chk[i]&&start.equals(tickets[i][0])){
                chk[i] = true;
                dfs(tickets, level+1, tickets[i][1], to + " " + tickets[i][1]);
                chk[i] = false;
            }
        }
        
    }
    
    public String[] solution(String[][] tickets) {
        chk = new boolean[tickets.length];
        
        dfs(tickets, 0, "ICN", "ICN");
        
        String[] answer = pq.peek().split(" ");
        return answer;
    }
}