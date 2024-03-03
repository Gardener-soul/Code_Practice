/* pq를 선언 , pq = 가장 작은 값이 최상단으로 올라가 반환함

1. 첫 째줄에 연산의 개수 N이 주어짐.
2. 0이 아니라면, pq에 넣고, 0이라면 poll
3. 배열의 사이즈가 0인데 0이면 0.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp==0 && pq.size()==0) System.out.println(0);
            else if(tmp!=0) pq.offer(tmp);
            else if(tmp==0 && pq.size()>0) System.out.println(pq.poll());
        }
    }
}
