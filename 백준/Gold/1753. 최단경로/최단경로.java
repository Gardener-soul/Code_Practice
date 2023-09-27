

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] distanceArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] arr = new ArrayList[v + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (arr[from] == null) {
                arr[from] = new ArrayList<>();
            }
            arr[from].add(new Edge(to, distance));
        }

        boolean[] chk = new boolean[v + 1];
        chk[0] = true;
        distanceArr = new int[v + 1];
        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        distanceArr[start] = 0;
        PriorityQueue<Edge> pQueue = new PriorityQueue<>();
        pQueue.offer(new Edge(start, 0));
        while (!pQueue.isEmpty()) {
            Edge now = pQueue.poll();
//            if (chk[now.to]) {
//                continue;
//            }
            chk[now.to] = true;
            if (arr[now.to] != null) {
                for (Edge next : arr[now.to]) {
                    if (chk[next.to]) {
                        continue;
                    }
                    if (distanceArr[next.to] > distanceArr[now.to] + next.distance) {
                        distanceArr[next.to] = distanceArr[now.to] + next.distance;
//                        pQueue.offer(next);
                        pQueue.offer(new Edge(next.to,next.distance+distanceArr[now.to]));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < distanceArr.length; i++) {
            if(distanceArr[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            }else {
                sb.append(distanceArr[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int distance;

        public Edge(int to, int distance) {
            super();
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.distance - o.distance;
        }

    }
}

