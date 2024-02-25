import java.util.*;

public class Solution {

    public int solution(int k, int n, int[][] reqs) {
        int ans = 0;
        List<List<Time>> typeTimes = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            typeTimes.add(new ArrayList<>());
        }

        for (int[] req : reqs) {
            int sTime = req[0];
            int dur = req[1];
            int type = req[2];
            typeTimes.get(type).add(new Time(sTime, sTime + dur));
        }

        int[][] waitTimes = new int[k + 1][n + 1];
        for (int type = 1; type < k + 1; type++) {
            if (typeTimes.get(type).isEmpty()) continue;
            for (int cs = 1; cs <= (n - k) + 1; cs++) {
                int wTime = calcTime(typeTimes.get(type), cs);
                waitTimes[type][cs] = wTime;
            }
        }

        int[] csPerType = new int[k + 1];
        Arrays.fill(csPerType, 1);
        int remainCs = n - k;

        while (remainCs-- > 0) {
            int maxReduce = 0, typeMax = 0;
            for (int type = 1; type < k + 1; type++) {
                int curCs = csPerType[type];
                int curWTime = waitTimes[type][curCs];
                int nextWTime = waitTimes[type][curCs + 1];
                int reduce = Math.abs(curWTime - nextWTime);
                if (reduce >= maxReduce) {
                    maxReduce = reduce;
                    typeMax = type;
                }
            }
            if (maxReduce == 0) break;
            csPerType[typeMax]++;
        }

        for (int type = 1; type < k + 1; type++) {
            if (typeTimes.get(type).isEmpty()) continue;
            int cs = csPerType[type];
            ans += waitTimes[type][cs];
        }

        return ans;
    }

    private int calcTime(List<Time> times, int csNum) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int wTime = 0;
        for (Time t : times) {
            if (pq.isEmpty() || pq.size() < csNum) {
                pq.add(t.end);
            } else {
                int eTime = pq.poll();
                if (t.start < eTime) {
                    wTime += (eTime - t.start);
                    pq.add(eTime + (t.end - t.start));
                } else {
                    pq.add(t.end);
                }
            }
        }
        return wTime;
    }

    private class Time {
        int start, end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
