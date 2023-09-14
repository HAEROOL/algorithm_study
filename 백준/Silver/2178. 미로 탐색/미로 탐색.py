from collections import deque

N, M = map(int, input().split())

matrix = [[0 for _ in range(M + 1)]]
visited = [[-1 for _ in range(M + 1)] for _ in range(N + 1)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

for _ in range(N):
    matrix.append([0] + list(map(int, list(input()))))

q = deque([(1, 1)])
visited[1][1] = 0
while q:
    x, y = q.popleft()
    

    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if 1 <= nx <= N and 1 <= ny <= M and visited[nx][ny] == -1 and matrix[nx][ny] != 0:
            visited[nx][ny] = visited[x][y] + 1
            q.append((nx, ny))

print(visited[N][M] + 1)