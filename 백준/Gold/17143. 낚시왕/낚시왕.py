R, C, M = map(int, input().split())
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
p = 0
# 속력 / 이동방향 / 크기
board = [[(0, 0, 0) for _ in range(C)]for _ in range(R)]

for _ in range(M):
    r,c,s,d,z = map(int,input().split())
    board[r - 1][c - 1] = (s,d - 1,z)
total = 0
while p < C:
    # for row in board:
    #     print(* row)
    for x in range(R):
        if board[x][p][2] != 0:
            # print(board[x][p][2])
            total += board[x][p][2]
            board[x][p] = (0, 0, 0)
            break
    newBoard = [[(0, 0, 0) for _ in range(C)]for _ in range(R)]
    for x in range(R):
        for y in range(C):
            cx, cy = x, y
            speed, dir, size = board[x][y]
            board[x][y] = (0, 0, 0)
            if size != 0:
                for _ in range(speed):
                    if 0 <= cx + dx[dir] < R and 0 <= cy + dy[dir] < C:
                        cx += dx[dir]
                        cy += dy[dir]
                    else:
                        if dir == 0: dir = 1
                        elif dir == 1: dir = 0
                        elif dir == 2: dir = 3
                        elif dir == 3: dir = 2
                        cx += dx[dir]
                        cy += dy[dir]
                if newBoard[cx][cy][2] != 0:
                    if newBoard[cx][cy][2] < size:
                        newBoard[cx][cy] = (speed, dir, size)
                else: newBoard[cx][cy] = (speed, dir, size)
    board = newBoard
    p += 1
print(total)