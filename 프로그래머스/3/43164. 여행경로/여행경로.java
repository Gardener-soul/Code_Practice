import java.util.*;

class Solution {
    static boolean[] chk;
    static PriorityQueue<String> pq = new PriorityQueue<>();
    
    public static void dfs(String[][] tickets, int idx, String start, String end) {
        if(idx==tickets.length) {
            pq.offer(end);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!chk[i] && start.equals(tickets[i][0])) {
                
                chk[i] = true;
                dfs(tickets, idx+1, tickets[i][1], end + " " + tickets[i][1]);
                chk[i] = false;
            }
            
        }
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        chk = new boolean[tickets.length];
        dfs(tickets, 0, "ICN", "ICN");
        answer = pq.peek().split(" ");
        return answer;
    }
}