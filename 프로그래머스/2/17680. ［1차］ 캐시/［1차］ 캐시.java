import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) {
                // 캐시 히트
                answer += 1;
            } else {
                // 캐시 미스
                answer += 5;
                if (cache.size() == cacheSize) {
                    cache.poll(); // 가장 오래된 항목 제거
                }
            }

            cache.offer(city); // 새로운 항목을 최신 상태로 추가
        }

        return answer;
    }
}
