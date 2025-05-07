function solution(s)
{
    var answer = 1;
    
    const dp = [];
    for(let i = 0 ; i < s.length ; i++){
        dp[i] = []
        for(let j = 0 ; j < s.length; j++){
            dp[i].push(false);
            if(i === j) dp[i][j] = true;
        }
    }
    for(let i = 0 ; i < s.length - 1; i++){
        if(s[i] === s[i + 1]){
            dp[i][i + 1] = true;
            answer = 2
        }
    }
    
    for(let i = 2 ; i < s.length + 1 ; i++){
        for(let start = 0 ; start <= s.length - i ; start++){
            const end = i + start - 1;
            if(s[start] === s[end] && dp[start + 1][end - 1]){
                dp[start][end] = true;
                answer = i;
            }
        }
    }
    
    // console.log(dp)
    
    return answer;
}