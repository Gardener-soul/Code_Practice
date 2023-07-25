class Solution {
    public int solution(int[] array, int n) {
        int answer = 100_000;
        for(int num : array){
            int diff = num - n;
            if(Math.abs(diff) < Math.abs(answer)){
                answer = diff;
            }else if(Math.abs(diff) == Math.abs(answer) && diff < answer){
                answer = diff;
            }
        }
        answer = n + answer;
        return answer;
    }
}

// class Solution {
//     public int solution(int[] array, int n) {
//         int answer = 0;
//         //절댓값이 가장 작은 배열의 위칫값을 찾을거다.
        
//         int min = 1000;
//         int idx = 0;
//         for(int i=0; i<array.length; i++){
//             if(min>Math.abs(array[i]-n)){
//                 min=Math.abs(array[i]-n);
//                 idx=i;
//             }
//         }
//         answer=array[idx];
//         return answer;
//     }
// }