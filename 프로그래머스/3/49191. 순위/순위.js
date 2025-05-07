function bfs(win, lose, start){
    v = new Array(win.length).fill(false);
    wq = [];
    wq.push(start);
    lq = [];
    lq.push(start);
    v[start] = true;
    while(wq.length !== 0){
        const now = wq.shift();
        for(const next of win[now]){
            if(!v[next]){
                wq.push(next);
                v[next] = true;
            }
        }
    }
    while(lq.length !== 0){
        const now = lq.shift();
        for(const next of lose[now]){
            if(!v[next]){
                lq.push(next);
                v[next] = true;
            }
        }
    }
    for(let i = 1 ; i < win.length ; i++){
        if(!v[i]) return false;
    }
    return true;
}
function solution(n, results) {
    var answer = 0;
    const win = []
    const lose = []
    for(let i = 0 ; i < n + 1 ; i++){
        win[i] = [];
        lose[i] = []
    }
    
    results.forEach(result => {
        const winner = result[0];
        const loser = result[1];
        win[winner].push(loser);
        lose[loser].push(winner);
    })
    
    for(let i = 1 ; i < n + 1 ; i++){
        if(bfs(win, lose, i)){
            answer++;
        }
    }
    return answer;
}