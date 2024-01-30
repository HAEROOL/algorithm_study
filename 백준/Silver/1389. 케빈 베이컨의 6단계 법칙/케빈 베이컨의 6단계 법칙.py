N, M = map(int, input().split())

inf = float('inf')

fmap = [[inf for _ in range(N + 1)]for _ in range(N + 1)]


for _ in range(M):
    a, b = map(int, input().split())
    fmap[a][b] = 1
    fmap[b][a] = 1

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(i + 1, N + 1):
            fmap[i][j] = min(fmap[i][j], fmap[i][k] + fmap[k][j])
            fmap[j][i] = fmap[i][j]

answer = [0, inf]

for x in range(1, N + 1):
    total = 0
    for y in fmap[x]:
        if y != inf:
            total += y
    
    if answer[1] > total:
        answer = [x, total]
print(answer[0])