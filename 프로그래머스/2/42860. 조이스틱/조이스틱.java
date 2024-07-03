public class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        // 알파벳 조작 최소 횟수 계산
        int[] moves = new int[n];
        for (int i = 0; i < n; i++) {
            moves[i] = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            answer += moves[i];
        }

        // 커서 이동 최소 횟수 계산
        int minMoves = n - 1;
        for (int i = 0; i < n; i++) {
            int next_i = i + 1;
            while (next_i < n && name.charAt(next_i) == 'A') {
                next_i++;
            }
            // 오른쪽으로 이동 후 왼쪽으로 돌아가는 경우
            int rightThenLeft = i + n - next_i + Math.min(i, n - next_i);
            // 현재 최소 이동 횟수와 비교하여 더 작은 값을 선택
            minMoves = Math.min(minMoves, rightThenLeft);
        }

        answer += minMoves;
        return answer;
    }
}
