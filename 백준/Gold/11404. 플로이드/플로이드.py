n = int(input())
m = int(input())

inf = float('inf')

board = [[inf for _ in range(n + 1)] for _ in range(n + 1)]

for _ in range(m):
    a,b,c = map(int, input().split())
    board[a][b] = min(board[a][b], c)

for x in range(1, n + 1):
    board[x][x] = 0

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            board[i][j] = min(board[i][j], board[i][k] + board[k][j])

for x in range(1, n + 1):
    for y in range(1, n + 1):
        if board[x][y] == inf:
            print(0, end=' ')
        else:
            print(board[x][y], end=' ')
    print()
