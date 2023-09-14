from collections import deque

M, N, H = map(int, input().split())
tomatoes = []
for _ in range(H):
    box = []
    for _ in range(N):
        box.append(list(map(int, input().split())))
    tomatoes.append(box)
dx = [1, 0, -1, 0, 0, 0]
dy = [0, 1, 0, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

q = deque()
for h in range(H):
    for x in range(N):
        for y in range(M):
            if tomatoes[h][x][y] == 1:
                q.append((h, x, y))

while q:
    h, x, y = q.popleft()
    for i in range(6):
        nz, nx, ny = dz[i] + h, dx[i] + x, dy[i] + y
        if 0 <= nx < N and 0 <= ny < M and 0 <= nz < H and tomatoes[nz][nx][ny] == 0:
            tomatoes[nz][nx][ny] = tomatoes[h][x][y] + 1
            q.append((nz, nx, ny))
answer = 1

for i in tomatoes:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit()
        answer = max(answer, max(j))

print(answer - 1)