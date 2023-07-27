class Solution {
    public int solution(String[] spell, String[] dic) {
        int result = 0;
        
        for(String d : dic){
            int cnt =0;
            for (String s : spell){
                if (d.contains(s)) {cnt++;}
            }
            if(cnt==spell.length) {
                result = 1;
                break;
            } else {result = 2;}
        }
    return result;
    }
}