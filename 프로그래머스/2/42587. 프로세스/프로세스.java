import java.util.*;
import java.io.*;

class Pair{
    int idx, pri;
    
    public Pair(int idx, int pri) {
        this.idx = idx;
        this.pri = pri;
    }
    
    @Override
    public String toString() {
        return idx + " " + pri;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int i=0; i<len; i++) {
            q.offer(new Pair(i, priorities[i]));
            map.put(priorities[i],map.getOrDefault(priorities[i],0)+1);
            max = Math.max(max, priorities[i]);
        }
        
        boolean flag = true;
        while(true) {
            Pair tmp = q.peek();
            int index = tmp.idx;
            int prior = tmp.pri;
            
            System.out.println(index + " " + prior);
            
            if(flag) {
                if(prior == max) {
                    q.poll();
                    map.put(max,map.getOrDefault(max,0)-1);
                    answer++;
                
                    if(index == location) break;
                
                } else {
                    q.poll();
                    q.offer(new Pair(index, prior));
                }         
            }
            
            if(map.getOrDefault(max,0)==0) {
                flag = false;
                max-=1;
            } else flag = true;
        }
        
        System.out.println(map);
        
        
        return answer;
    }
}