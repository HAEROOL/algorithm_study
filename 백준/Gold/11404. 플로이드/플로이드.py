n = int(input())
m = int(input())

inf = float('inf')

board = [[inf for _ in range(n + 1)]for _ in range(n + 1)]
for _ in range(m):
    i, j, k = map(int, input().split())
    board[i][j] = min(board[i][j], k)

for i in range(1, n+1):
    board[i][i] = 0

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            board[i][j] = min(board[i][j], board[i][k] + board[k][j])

for r in range(1, n + 1):
    for e in range(1, n + 1):
        if board[r][e] == inf:
            board[r][e] = 0
        print(board[r][e], end=' ')
    print()