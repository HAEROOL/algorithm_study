function solution(s)
{
    var answer = 1;
    
   const dp = []
   for(let i = 0 ; i < s.length ; i++){
       dp[i] = [];
       for(let j = 0 ; j < s.length ; j++){
           dp[i].push(false);
           if(i === j)dp[i][j] = true;
       }
   }
    
    for(let i = 0 ; i < s.length - 1;i++){
        if(s[i] === s[i + 1]){
            dp[i][i + 1] = true;
            answer = 2;
        }
    }
    
    for(let i = 3 ; i <= s.length ; i++){
        for(let j = 0 ; j < s.length - i + 1 ; j++){
            const end = j + i - 1;
            if(s[j] === s[end] && dp[j + 1][end - 1]){
                dp[j][end] = true;
                answer = i;
            }
        }
    }
    
    return answer;
}