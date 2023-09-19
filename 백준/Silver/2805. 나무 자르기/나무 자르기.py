N, M = map(int, input().split())

trees = list(map(int, input().split()))

def solve(mid):
    curr = 0
    for i in trees:
        if i >= mid:
            curr += i - mid
    return curr >= M

st = 1
en = max(trees)

while st <= en:
    mid = (st + en ) // 2 
    if solve(mid): st = mid + 1
    else: en = mid -1
print(en)