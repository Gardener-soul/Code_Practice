import java.util.*;

class Solution {
    public List<String> solution(String[] todo_list, boolean[] finished) {
        List<String> str = new ArrayList<>();
        for(int i=0; i<finished.length; i++){
            if(!finished[i]){
                str.add(todo_list[i]);
            }
        }
        return str;
    }
}