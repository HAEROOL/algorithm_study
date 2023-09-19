board = []
blank = []
for x in range(9):
    board.append(list(map(int, input().split())))
    for y in range(9):
        if board[x][y] == 0:
            blank.append((x, y))

def checkRow(x, a):
    for i in range(9):
        if a == board[x][i]:
            return False
    return True

def checkCol(y, a):
    for i in range(9):
        if a == board[i][y]:
            return False
    return True

def checkRect(x,y,a):
    nx = x // 3 * 3
    ny = y // 3 * 3
    for i in range(3):
        for j in range(3):
            if a == board[nx + i][ny + j]:
                return False
    return True

def dfs(idx):
    if idx == len(blank):
        for i in range(9):
            print(*board[i])
        exit(0)
    for i in range(1, 10):
        x, y = blank[idx]
        if checkRow(x, i) and checkCol(y, i) and checkRect(x,y,i):
            board[x][y] = i
            dfs(idx + 1)
            board[x][y] = 0

dfs(0)