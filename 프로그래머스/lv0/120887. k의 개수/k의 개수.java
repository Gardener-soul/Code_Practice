class Solution {
    public int solution(int i, int j, int k) {
        int answer=0;
            for(int a=i; a<=j; a++) {                       //i에서 j까지
                String s=String.valueOf(a);                 //int a를 String s로 변환
                char[] ch=s.toCharArray();                  //s에 있는 숫자 하나하나를 배열에 저장
                for(int b=0; b<ch.length; b++) {            
                    if(ch[b]==Character.forDigit(k, 10)) {  //k와 ch배열의 b번째 와 같으면
                        answer++;                           //answer에 1을 더함
                    }
                }
            }
        return answer;
    }
}



// class Solution {
//     public int solution(int i, int j, int k) {
//         int answer = 0;
        
//         //k가 10보다 클 때 나누기까지 생각, 아니면 걍 1
//         //나눈 값과 나머지의 값이 k와 동일하면 answer+1 이걸 계속 반복.
//         //이 때, i부터 j까지 포함
//         //그럼 뭘로 나눌거냐면, 10의 배수로 나눌거임
//         //없을 땐 어카지  
        
//         //a를 10으로 고정시키고 i를 10으로 나눠야함
//         for(i=i; i<=j; i++){
//             if(i>=10){
//                 if(i/10==k&&i%10==k) answer+=1; //11
//                 if(i/10==k) answer+=1; //10 11 12 13
//                 if(i%10==k) answer+=1; //1 
//             } else if (i%10==k) answer+=1;     
//             else answer=0;
//             i=i/10;
//         }
//     return answer;     
//         // for(i=i; i<=j; i++){
//         //     if(i>=10){
//         //         for(int a=10; a<=100000; a=a*10){
//         //             if(i/a==k&&i%a==k) {answer+=1;} //11
//         //             if(i/a==k) {answer+=1;} //10 11 12 13
//         //             if(i%a==k) {answer+=1;} //1
//         //         } 
//         //     } else if (i%10==k) {answer+=1;}
//         //     else answer=0;
//         // }
//         // return answer;
//     }
// }