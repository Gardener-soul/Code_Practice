import java.util.*;

class Solution {
    public Queue<Integer> solution(int[] num_list, int n) {
        Queue<Integer> num = new LinkedList<>();
        for(int i=0; i<num_list.length; i++){
            num.add(num_list[i]);
        }
        while(n!=0){
            num.offer(num.poll());
            n--;
        }
        return num;
    }
}