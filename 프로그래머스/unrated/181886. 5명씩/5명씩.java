import java.util.*;

class Solution {
    public List<String> solution(String[] names) {
        List<String> str = new ArrayList<>();
        if(names.length>=5){
            for(int i=1; i<=names.length;i++){
                if(i%5==1){
                    str.add(names[i-1]);
                }
            }
        } else {
            str.add(names[0]);
        }
        return str;
    }
}