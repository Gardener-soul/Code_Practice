import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int len = Integer.parseInt(st.nextToken()); // 배열 길이
        int[] arr = new int[len];
        int dis = Integer.parseInt(st.nextToken()); // 다리 길이
        int wei = Integer.parseInt(st.nextToken()); // 다리가 버티는 무게

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<len; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int time = 0;

        for(int i=0; i<arr.length; i++){
            int truck = arr[i];
            while(true){
                // 만일 q가 비었을 경우, q에 넣고 sum 과 시간을 더하고, while 문을 빠져나옴
                if(q.isEmpty()) {
                    q.offer(truck);
                    sum+=truck;
                    time++;
                    break;
                    // q가 꽉 찼을 경우 q.poll
                } else if (q.size()==dis){
                    sum-=q.poll();
                    // q가 꽉 차지 않았다면, 무게를 생각해야함
                } else {
                    if(sum + truck <= wei) {
                        q.offer(truck);
                        sum+=truck;
                        time++;
                        break;
                        // q가 꽉 차지 않았다면, q의 사이즈를 늘려서, 트럭이 지나가게함
                    } else {
                        q.offer(0);
                        time++;
                    }
                }
            }
        }
        // 마지막 트럭은 어떻게든 지나갈 수 있다. 그렇게이 다리 길이만큼 더해줌
        System.out.println(time+dis);
    }
}
