import java.util.*;

class Solution {
    public List<String> solution(String myStr) {
        String str = "";
        str = myStr.replaceAll("[a-c]", "_");
		String[] answer = str.split("_");
		List<String> arr = new ArrayList<>();
		for(int i=0; i<answer.length; i++) {
			if(!answer[i].isEmpty()) {
				arr.add(answer[i]);
			}
		}
        if(arr.size()==0){
            arr.add("EMPTY");
            return arr;
        } else return arr;
    }
}