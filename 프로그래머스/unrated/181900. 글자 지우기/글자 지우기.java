import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);
        
        List<String> ans = new ArrayList<>();
		
		String[] str = my_string.split("");
		for(int i=0; i<indices.length; i++) {			
			str[indices[i]] = "";
		}
		
		for(int i=0; i<str.length; i++) {
			if(!str[i].equals("")) {
				ans.add(str[i]);
			}
		}
		for(int i=0; i<ans.size(); i++) {
			answer+=ans.get(i);
		}
        
        return answer;
    }
}