from collections import deque

M, N = map(int, input().split())
tomatoes = []
for _ in range(N):
    tomatoes.append(list(map(int, input().split())))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

q = deque()

for x in range(N):
    for y in range(M):
        if tomatoes[x][y] == 1:
            q.append((x, y))


while q:
    x, y = q.popleft()
    for i in range(4):
        nx, ny = dx[i] + x, dy[i] + y
        if 0 <= nx < N and 0 <= ny < M and tomatoes[nx][ny] == 0:
            tomatoes[nx][ny] = tomatoes[x][y] + 1
            q.append((nx, ny))
answer = 1

for i in tomatoes:
    for j in i:
        if j == 0:
            print(-1)
            exit()
    answer = max(answer, max(i))

print(answer - 1)