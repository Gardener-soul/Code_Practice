import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        
        for(int i = 0; i < indices.length; i ++) my_string = my_string.substring(0, indices[i] - i) + my_string.substring(indices[i] - i + 1);
        
        return my_string;
    }
}