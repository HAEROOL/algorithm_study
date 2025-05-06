function solution(A, B) {
    var answer = -1;
    A.sort((a, b) => a - b);
    B.sort((a, b) => a - b);
    let a = 0;
    let b = 0;
    answer = 0;
    while(b < B.length){
        const anum = A[a];
        const bnum = B[b];
        if(anum < bnum){
            answer ++;
            a++;
        }
        b++;
    }
    return answer;
}