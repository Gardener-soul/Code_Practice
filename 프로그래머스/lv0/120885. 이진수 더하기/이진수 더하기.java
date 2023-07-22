class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);
        int res = num1+num2;
        answer = Integer.toBinaryString(res);
        return answer;
    }
}

// class Solution {
//     public String solution(String bin1, String bin2) {
        
//         int one = Integer.valueOf(bin1);
//         int two = Integer.valueOf(bin2);
        
//         int sum =0;
//         sum = one + two;
// 	    double a=0;
// 	    int i=0;
// 		String answer = "";
		
// 	        while(sum>=1){
// 	        a=a+(sum%10)*(Math.pow(2, i));
// 	        sum=sum/10;
// 	        i++;
// 	        }
	        
// 	        int d;
// 	        int b=0;
// 	        int cnt = 0;
	        
// 	        d=(int)a;
	        
// 	        while(d>=1) {
// 	        	d=(int)d/2;
// 	        	cnt++;
// 	        }
	        
// 	        int[] num = new int [cnt];
	        
// 	        for(int o=0; o<num.length; o++) {
// 	        	if(a>=1){
// 	     	      	a=(int)Math.round(a);
// 	     	       	b=(int)a%2;
// 	        		num[o]+=b;
// 	        		a=(int)a/2;
// 	        	}
// 	        }
// 	      for(int e=num.length-1; e>=0; e--) {
// 	    	  answer+=num[e];
// 	      }
//         return answer;
//     }
// }