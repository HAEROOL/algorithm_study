from collections import deque

n, m = map(int, input().split())

board = []
coords = []

visited = [[0 for _ in range(m)]for _ in range(n)]

answer = [0]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
for _ in range(n):
    board.append(list(map(int, input().split())))

for x in range(n):
    for y in range(m):
        if board[x][y] == 1:
            coords.append((x, y))

def bfs(x,y):
    if visited[x][y] == 0:
        q = deque()
        q.append((x, y))
        visited[x][y] = 1
        width = 0
        while q:
            width += 1
            a, b = q.popleft()
            for i in range(4):
                nx = a + dx[i]
                ny = b + dy[i]
                if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 1 and visited[nx][ny] == 0:
                    q.append((nx, ny))
                    visited[nx][ny] = visited[a][b] + 1
        answer.append(width)
for coord in coords:
    x, y = coord
    bfs(x, y)

print(len(answer) - 1)
print(max(answer))