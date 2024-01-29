from collections import deque

t = int(input())

for _ in range(t):
    answer = 0
    M, N, K = map(int, input().split())
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    cabages = []

    board = [[0 for _ in range(N)] for _ in range(M)]
    visited = [[False for _ in range(N)] for _ in range(M)]

    for i in range(K):
        x, y = map(int, input().split())
        cabages.append((x, y))
        board[x][y] = 1

    
    for coord in cabages:
        x, y = coord
        if not visited[x][y]:
            answer += 1
            q = deque()
            q.append((x, y))
            visited[x][y] = True
            while q:
                x, y = q.popleft()
                for a in range(4):
                    nx = x + dx[a]
                    ny = y + dy[a]
                    if 0 <= nx < M and 0 <= ny < N and not visited[nx][ny] and board[nx][ny] == 1:
                        q.append((nx, ny))
                        visited[nx][ny] = True
                        
    print(answer)
