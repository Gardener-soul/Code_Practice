class Solution {
    public int solution(int[] common) {
        int result=0;
        
        if(common[1]-common[0] == common[2]-common[1]) {
			result = common[common.length-1]+(common[2]-common[1]);
		} else {result = common[common.length-1]*(common[1]/common[0]);}
		
		// if(common[1]/common[1]==common[1]/common[0]) {
		// 	result = common[common.length-1] * (common[1]/common[0]);
		// }
        
        return result;
    }
}