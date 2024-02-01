N, M = map(int, input().split())

trees = list(map(int, input().split()))

def solve(mid):
    total = 0
    for i in trees:
        if i >= mid:
            total += i - mid
    return total >= M

st = 1
en = max(trees)

while st <= en:
    mid = (st + en ) // 2 
    if solve(mid): st = mid + 1
    else: en = mid -1
print(en)