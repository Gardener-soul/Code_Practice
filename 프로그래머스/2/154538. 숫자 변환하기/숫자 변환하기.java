import java.util.*;

class Pair {
    int num, cnt;
    
    public Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        return performBFS(x, y, n);
    }
    
    private int performBFS(int x, int y, int n) {
        int answer = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();
        boolean[] chk = new boolean[1000001];
        
        q.offer(new Pair(x, 0));
        
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            int num = tmp.num;
            int cnt = tmp.cnt;
            
            if (num == y) {
                return cnt;
            }
            
            if (num + n <= y && !chk[num + n]) {
                chk[num + n] = true;
                q.offer(new Pair(num + n, cnt + 1));
            }
            
            if (num * 2 <= y && !chk[num * 2]) {
                chk[num * 2] = true;
                q.offer(new Pair(num * 2, cnt + 1));
            }
            
            if (num * 3 <= y && !chk[num * 3]) {
                chk[num * 3] = true;
                q.offer(new Pair(num * 3, cnt + 1));
            }
        }
        
        return -1;
    }
}
