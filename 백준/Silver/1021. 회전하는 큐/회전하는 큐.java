/*
* 0. N개의 원소를 포함하는 Deque를 사용한다.
* 1. 첫 번째 원소를 뽑아낸다. a1, a2 ... ak -> a2,,,ak
* 2. 왼 쪽으로 한 칸 이동시킴 a1,a2,,,ak -> a2,a3,,ak,a1
* 3. 오른쪽으로 한 칸 이동시킴 a1,, ak -> ak, a1,,,ak-1
*
* 처음 포함되어있던 수 N이 주어짐, 이 원소를 주어진 순서대로 뽑아드는데 드는 2,3번 연산의 최솟값을 출력
*
* 큐의 크기 N, 뽑아내려고 하는 수, M / 둘 째 줄 뽑아내려고 하는 수의 위치
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            dq.offer(i);
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i=0; i<M; i++){
            int tmp = Integer.parseInt(st2.nextToken());
            int target = dq.indexOf(tmp);
            int half;

            if(dq.size()%2==0){
                half = dq.size()/2-1;
            } else half=dq.size()/2;

            if(target<=half){
                for(int j=0; j<target; j++){
                    int temp = dq.pollFirst();
                    dq.addLast(temp);
                    ans++;
                }
            } else {
                for(int j=0; j<dq.size()-target; j++){
                    int temp = dq.pollLast();
                    dq.addFirst(temp);
                    ans++;
                }
            }

            dq.pollFirst();
        }
        System.out.println(ans);
    }
}
