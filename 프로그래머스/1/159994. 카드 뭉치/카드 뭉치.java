import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> goalQ = new LinkedList<>();
        for(int i=0; i<goal.length; i++) {
            goalQ.add(goal[i]);
        }
        
        int card1 = 0, card2=0;
        for(int i=0; i<goal.length; i++) {
            if(card1 < cards1.length && goalQ.peek().equals(cards1[card1])) {
                goalQ.poll();
                card1++;
            } else if (card2 < cards2.length && goalQ.peek().equals(cards2[card2])) {
                goalQ.poll();
                card2++;
            }
        }
        
        if(goalQ.isEmpty()) answer="Yes";
        else answer = "No";
        
        return answer;
    }
}