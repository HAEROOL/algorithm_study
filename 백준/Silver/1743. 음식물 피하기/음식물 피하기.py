from collections import deque
N, M, K = map(int, input().split())

matrix = [[0 for _ in range(M)]for _ in range(N)]
visited = [[False for _ in range(M)]for _ in range(N)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0 , -1]
coords = []
for _ in range(K):
    x, y = map(int, input().split())
    matrix[x - 1][y - 1] = 1
    coords.append((x - 1, y - 1))
answer = 0
for coord in coords:
    x, y = coord
    q = deque([(x, y)])
    visited[x][y] = True
    total = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M and matrix[nx][ny] == 1 and not visited[nx][ny]:
                q.append((nx, ny))
                visited[nx][ny] = True
                total += 1
    answer = max(answer, total)
print(answer)