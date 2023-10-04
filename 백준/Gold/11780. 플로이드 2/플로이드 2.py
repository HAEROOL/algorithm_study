n = int(input())
m = int(input())

inf = float('inf')

board = [[inf for _ in range(n + 1)]for _ in range(n + 1)]
nxt = [[-1 for _ in range(n + 1)]for _ in range(n + 1)]
for _ in range(m):
    i, j, k = map(int, input().split())
    board[i][j] = min(board[i][j], k)
    nxt[i][j] = j
    
for i in range(1, n+1):
    board[i][i] = 0

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if board[i][k] + board[k][j] < board[i][j]:
                board[i][j] = min(board[i][k] + board[k][j], board[i][j])
                nxt[i][j] = nxt[i][k]

for r in range(1, n + 1):
    for e in range(1, n + 1):
        if board[r][e] == inf:
            board[r][e] = 0
        print(board[r][e], end=' ')
    print()

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if nxt[i][j] == -1:
            print(0)
            continue
        ans = []
        v = i

        while v != j:
            ans.append(v)
            v = nxt[v][j]
        ans.append(j)
        print(len(ans), *ans)