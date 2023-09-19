from collections import deque

N, M = map(int, input().split())
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
board = []

for _ in range(0, N):
    board.append(list(map(int, list(input()))))

visited = [[[0] * 2 for _ in range(M)]for _ in range(N)]

visited[0][0][0] = 1


def bfs(x,y,z):
    queue = deque()
    queue.append((x,y,z))

    while queue:
        a,b,c = queue.popleft()
        if a == N - 1 and b == M - 1:
            return visited[a][b][c]
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if board[nx][ny] == 1 and c == 0:
                visited[nx][ny][1] = visited[a][b][0] + 1
                queue.append((nx, ny, 1))
            elif board[nx][ny] == 0 and visited[nx][ny][c] == 0:
                visited[nx][ny][c] = visited[a][b][c] + 1
                queue.append((nx, ny, c))
    return -1

print(bfs(0,0,0))

