N, C = map(int, input().split())
coords = []


for _ in range(0, N):
    coords.append(int(input()))
coords.sort()

st = 1
en = coords[N-1] - coords[0]
answer = 0

while st <= en:
    mid = (st + en) // 2
    curr = coords[0]
    count = 1
    for i in range(0, N):
        if coords[i] >= curr + mid:
            count += 1
            curr = coords[i]
    if count >= C:
        st = mid + 1
        answer = mid
    else:
        en = mid - 1
print(answer)