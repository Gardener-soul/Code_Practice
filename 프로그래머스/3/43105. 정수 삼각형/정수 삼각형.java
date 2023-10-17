class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] res = new int[N][N];
        res = triangle;
        
    	for(int i=N-2; i>=0; i--) {
    		for(int j=0; j<triangle[i].length; j++) {
    			res[i][j] = Math.max(res[i][j] + res[i+1][j], res[i][j]+res[i+1][j+1]);
    		}
    	}
        
        answer=res[0][0];
        
        return answer;
    }
}