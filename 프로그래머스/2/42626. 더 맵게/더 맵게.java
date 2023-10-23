import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();
		int len = scoville.length;
		
		for(int i=0; i<len; i++) {
			pq.offer(scoville[i]);
		}
		int tmp = len;
		
		while(tmp>0) {
			
			if(pq.peek()>=K) {
				int res = pq.poll();
				list.add(res);
			} else {
				
				if(pq.size()>1) {
					
					int a = pq.poll();
					int b = pq.peek();
					
					int c = a + b*2;
					
					pq.offer(c);
					pq.poll();
				} else {
					break;
				}
				
			}
			
			tmp--;
			
		}
		
		if(pq.size()==1) {
			return -1;
		} else {
			return len-list.size();
		}

    }
}