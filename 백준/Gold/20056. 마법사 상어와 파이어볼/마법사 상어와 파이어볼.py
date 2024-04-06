n, m, k = map(int, input().split())

board = [[[] for _ in range(n)]for _ in range(n)]

for _ in range(m):
    x, y, m, s, d = map(int, input().split())
    board[x - 1][y - 1].append((m, s, d))

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

def move(board):
    newBoard = [[[] for _ in range(n)]for _ in range(n)]
    for x in range(n):
        for y in range(n):
            if len(board[x][y]) != 0:
                for fire in board[x][y]:
                    m, s, d = fire
                    nx = (x + dx[d] * s) % n
                    ny = (y + dy[d] * s) % n
                    newBoard[nx][ny].append((m, s, d))
    return newBoard

def calculate(board):
    newBoard = board
    for x in range(n):
        for y in range(n):
            if len(newBoard[x][y]) > 1:
                totalM = 0
                totalS = 0
                # 홀수면 1, 짝수면 2
                dirs = []
                for fire in newBoard[x][y]:
                    m, s, d = fire
                    totalM += m
                    totalS += s
                    dirs.append(1 if d % 2 == 1 else 2)
                calM = totalM // 5
                if calM == 0:
                    newBoard[x][y] = []
                    continue
                calS = totalS // len(newBoard[x][y])
                if dirs == [1] * len(newBoard[x][y]) or dirs == [2] * len(newBoard[x][y]):
                    tmp = []
                    for i in range(4):
                        tmp.append((calM, calS, i * 2))
                    newBoard[x][y] = tmp
                else:
                    tmp = []
                    for i in range(4):
                        tmp.append((calM, calS, (i * 2) + 1))
                    newBoard[x][y] = tmp
    return newBoard
                



while k != 0:
    board = move(board)
    board = calculate(board)
    k -= 1
total = 0
for x in range(n):
    for y in range(n):
        if len(board[x][y]) != 0:
            for fire in board[x][y]:
                m, s, d = fire
                total += m
print(total)

