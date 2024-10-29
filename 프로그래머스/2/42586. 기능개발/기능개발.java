import java.util.*;

class Job {
    int idx, pro, day;
    
    public Job(int idx, int pro, int day) {
        this.idx = idx;
        this.pro = pro;
        this.day = day;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Job> q = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();
        
        for(int i=0; i<speeds.length; i++) {
            q.offer(new Job(i+1, progresses[i], 0));
            s.offer(speeds[i]);
        }
        int[] days = new int[101];
        boolean[] chk = new boolean[speeds.length+1];
        chk[0] = true;
        
        while(!s.isEmpty()) {
            int qnow = q.peek().pro;
            int qidx = q.peek().idx;
            int qday = q.peek().day+1;
            int snow = s.peek();
            
            if(snow+qnow>=100 && chk[qidx-1]) {
                q.poll();
                s.poll();
                days[qday]++;
                chk[qidx] = true;
            } else {
                q.poll();
                s.poll();
                q.offer(new Job(qidx, qnow+snow, qday));
                s.offer(snow);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<101; i++) {
            if(days[i]!=0) ans.add(days[i]);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}