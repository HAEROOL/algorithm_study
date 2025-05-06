function solution(k, tangerine) {
    var answer = 0;
    const dict = {}
    tangerine.forEach(t => {
        if(dict[t]){
            dict[t] ++;
        }else{
            dict[t] = 1
        }
    })
    const arr = Object.keys(dict).sort((a, b) => dict[b] - dict[a]);
    
    for(const val of arr){
        answer++;
        k -= dict[val];
        if(k <= 0) break;
    }
    
    return answer;
}