class Solution {
    public int solution(String my_string) {
		int sum=0;
        
        my_string = my_string.replaceAll("[a-zA-Z]"," ");
        
        String[] Sarr = my_string.split(" ");
        
        for(int i=0; i<Sarr.length; i++) {
        	if(Sarr[i].isEmpty()==false)
        	sum+=Integer.parseInt(Sarr[i]);
        }
        return sum;
    }
}