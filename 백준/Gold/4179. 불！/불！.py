from sys import stdin
from collections import deque

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
r, c = map(int, stdin.readline().split())
board, res = [], 0

# 지환이와 불난 곳 저장할 변수
F, J = deque(), deque()

for i in range(r):
    data = list(stdin.readline().rstrip())
    for j in range(c):
        if data[j] == 'J':
            J.append((i, j))
        if data[j] == 'F':
            F.append((i, j))

    board.append(data)


def bfs():
    global F, J, res

    while 1:
        res += 1
        temp = []
        while F:
            x, y = F.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if -1 < nx < r and -1 < ny < c:
                    if board[nx][ny] == '.' or board[nx][ny] == '$':
                        temp.append((nx, ny))
                        board[nx][ny] = 'F'
        F = deque(temp)

        temp = []
        while J:
            x, y = J.popleft()
            if x == 0 or y == 0 or x == r - 1 or y == c - 1:
                return res

            for i in range(4):
                nx, ny = dx[i] + x, dy[i] + y
                if -1 < nx < r and -1 < ny < c and board[nx][ny] == '.':
                    temp.append((nx, ny))
                    board[x][y] = '$'
                    board[nx][ny] = 'J'

        J = deque(temp)
        if not J:
            return False


if bfs():
    print(res)
else:
    print('IMPOSSIBLE')