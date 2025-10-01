N, M = map(int, input().split())

inf = float('inf')

fmap = [[inf for _ in range(N + 1)]for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    fmap[a][b] = 1
    fmap[b][a] = 1

for x in range(1, N + 1):
    fmap[x][x] = 0

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            fmap[i][j] = min(fmap[i][j], fmap[i][k] + fmap[k][j])

arr = []
for x in range(1, N + 1):
    arr.append((sum(fmap[x][1:]), x))
arr.sort()
print(arr[0][1])