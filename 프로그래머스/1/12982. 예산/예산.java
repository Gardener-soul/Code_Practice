import java.util.*;
import java.io.*;

/*
1. 전체 예산이 정해져있음, 최대한 많은 부서의 물품을 구매해줘야함
2. 부서가 지원한 금액에 정확히 지원함 if 1000 -> 1000 원 지원
3. 최대 몇 개의 부서에 지원할 수 있는지 return해야함.

1) Arrays.sort 하면,, 반례가 있을라나?
2) 반복문 돌면서 작은 것부터 계산하고, 크면 이제 break?
*/

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++){
            if(d[i]<=budget) {
                budget-=d[i];
                answer++;
            }
        }
        
        return answer;
    }
}