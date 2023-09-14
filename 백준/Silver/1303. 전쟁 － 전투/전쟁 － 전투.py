from collections import deque

N, M = map(int, input().split())

matrix = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
b = 0
w = 0
bs = []
ws = []
cords = [ws, bs]
for _ in range(M):
    matrix.append(list(input()))


for x in range(M):
    for y in range(N):
        if matrix[x][y] == 'B':
            bs.append((x, y))
        else: ws.append((x, y))
visited = [[False for _ in range(N)]for _ in range(M)]

for cord in cords:
    for scord in cord:
        q = deque()
        x, y = scord
        q.append((x, y))
        s = matrix[x][y]
        total = 0
        if not visited[x][y]:
            visited[x][y] = True
            total += 1
        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = dx[i] + x
                ny = dy[i] + y
                if 0 <= nx < M and 0 <= ny < N and matrix[nx][ny] == s and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    total += 1
        if s == 'W':
            w += (total**2)
        else:
            b += (total**2)
print(w, b)