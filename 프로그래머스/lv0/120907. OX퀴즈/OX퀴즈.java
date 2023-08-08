class Solution {
    public String[] solution(String[] quiz) {
        /* 
        1. 문자열 배열 quiz의 각 수식을 숫자와 연산자만 남겨 새로운 2차열 배열에 담음
        2. 배열 0, 2번째를 1번째 부호로 계산 -> 배열 4번째랑 같다면 "O" / 다르다면 "X"        
        */
        
        String[][] str_arr = new String[quiz.length][5];
        String[] answer = new String[quiz.length];

        for(int i=0; i<quiz.length; i++){         
            str_arr[i] = quiz[i].split(" ");
            
            int result = 0;
            if(str_arr[i][1].equals("+")){
                result = Integer.parseInt(str_arr[i][0]) + Integer.parseInt(str_arr[i][2]);
                if(result == Integer.parseInt(str_arr[i][4])){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }else if(str_arr[i][1].equals("-")){
                result = Integer.parseInt(str_arr[i][0]) - Integer.parseInt(str_arr[i][2]);
                if(result == Integer.parseInt(str_arr[i][4])){
                    answer[i] = "O";  
                }else{
                    answer[i] = "X";  
                }
            }
        }      
        return answer;
    }
}