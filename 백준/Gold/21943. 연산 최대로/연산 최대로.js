const fs = require("fs");
const [L1, L2, L3] = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const N = +L1;
const nums = L2.split(" ").map(Number);
let ops = L3.split(" ").map(Number);
const P = ops[0];
const Q = ops[1];
let ans = 0;
function permutaion(depth, sel, v) {
  if (depth === N + P + Q) {
    let tmp = sel[0];
    let total = 1;
    for (let i = 1; i < sel.length - 1; i += 2) {
      let num = sel[i + 1];
      let op = sel[i];
      if (op === 1) {
        total *= tmp;
        tmp = num;
      } else {
        tmp += num;
      }
    }
    total *= tmp;
    ans = Math.max(ans, total);
    return;
  }
  if (depth % 2 === 0) {
    for (let i = 0; i < N; i++) {
      if (!v[i]) {
        v[i] = true;
        sel.push(nums[i]);
        permutaion(depth + 1, sel, v);
        sel.pop();
        v[i] = false;
      }
    }
  } else {
    for (let i = 0; i < 2; i++) {
      if (ops[i] !== 0) {
        ops[i]--;
        sel.push(i);
        permutaion(depth + 1, sel, v);
        sel.pop();
        ops[i]++;
      }
    }
  }
}

permutaion(0, [], new Array(N).fill(false));

console.log(ans);
