import java.util.*;

public class Pair{
    double res;
    int index;
    
    public Pair(double res, int index) {
        this.res = res;
        this.index = index;
    }
    
    @Override
    public String toString() {
        return "(" + res +" " + index + ")";
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        ArrayList<Pair> res = new ArrayList<>();
        int[] answer = new int[N];
        int[] sta = new int[N];
        int[] peo = new int[N];
        int all = stages.length;
        
        for(int i=0; i<all; i++) {
            if(stages[i]<=N) sta[stages[i]-1]++;
        }
        
        peo[0] = all;
        for(int i=1; i<N; i++) {
            peo[i] = all-sta[i-1];
            all -= sta[i-1];
        }
        
        for(int i=0; i<N; i++) {
            if(peo[i]==0) res.add(new Pair(0,i+1));
            else res.add(new Pair( (double) sta[i]/peo[i],i+1));
        }
        
        Collections.sort(res, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.res == p2.res) {
                    return Integer.compare(p1.index, p2.index);
                }
                return Double.compare(p2.res, p1.res);
            }
        });
        
        for(int i=0; i<N; i++){
            answer[i] = res.get(i).index;
        }
        
        return answer;
    }
}