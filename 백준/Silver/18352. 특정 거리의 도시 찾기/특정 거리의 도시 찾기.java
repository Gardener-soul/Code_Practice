/*
입력 : N,M,K,X / 도시 개수, 도로 개수, 거리 정보, 출발 도시

1. bfs
2. 해당 도시의 거리가 맞으면 arrayList에 추가.
3. 정렬
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int city, dist;
    public Pair(int city, int dist) {
        this.city = city;
        this.dist = dist;
    }
}

public class Main {

    static int N,M,K,X;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> res = new ArrayList<>();
    static boolean[] chk;

    public static void bfs(int start){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start,0));
        chk[start] = true;

        while(!q.isEmpty()){
            Pair tmp = q.poll();
            int city = tmp.city;
            int dist = tmp.dist;

            if(dist==K) res.add(city);

            for(int visit : graph[city]){
                if(!chk[visit]){
                    q.offer(new Pair(visit, dist+1));
                    chk[visit] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        chk = new boolean[N+1];
        graph = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
        }

        bfs(X);

        Collections.sort(res);

        if(res.isEmpty()) System.out.println(-1);
        else {
            for(int i=0; i<res.size(); i++){
                System.out.println(res.get(i));
            }
        }
    }
}