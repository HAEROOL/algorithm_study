function solution(n)
{
    var ans = 0;
    let node = n;
    while(node !== 1){
        // console.log(node)
        if(node % 2 != 0){
            ans++;
        }
        node = Math.floor(node / 2);
    }

    return ans + 1;
}