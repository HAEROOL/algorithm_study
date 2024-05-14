from collections import deque

n, m = map(int, input().split())

board = []
visited = [[-1 for _ in range(m)] for _ in range(n)]
sx, sy = -1, -1
for x in range(n):
    row = list(map(int, input().split()))
    for y in range(m):
        if row[y] == 2:
            sx = x
            sy = y
    board.append(row)

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

q = deque([(sx, sy)])
visited[sx][sy] = 0
while q:
    x, y = q.pop()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<n and 0<=ny<m and board[nx][ny] == 1 and visited[nx][ny]==-1:
            q.appendleft((nx, ny))
            visited[nx][ny] = visited[x][y] + 1
for x in range(n):
    for y in range(m):
        if visited[x][y] == -1:
            if board[x][y] == 1: visited[x][y] = -1
            if board[x][y] == 0: visited[x][y] = 0
for row in visited:
    print(*row)