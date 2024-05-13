from collections import deque

t = int(input())

for _ in range(t):
    answer = 0
    M, N, K = map(int, input().split())
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    cabages = []

    board = [[0 for _ in range(M)] for _ in range(N)]
    visited = [[False for _ in range(M)] for _ in range(N)]

    for _ in range(K):
        y, x = map(int, input().split())
        board[x][y] = 1
        cabages.append((x, y))

    answer = 0
    for cx, cy in cabages:
        if not visited[cx][cy]:
            answer += 1
            q = deque([(cx, cy)])
            visited[cx][cy] = True
            while q:
                x, y = q.pop()
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and board[nx][ny] == 1:
                        q.appendleft((nx, ny))
                        visited[nx][ny] = True
    print(answer)