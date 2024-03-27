from collections import deque

N = int(input())

board = []
stx, sty = 0, 0
for x in range(N):
    row = list(map(int, input().split()))
    board.append(row)
    for y in range(N):
        if row[y] == 9:
            stx, sty = x, y
            board[x][y] = 0
size = 2
eat = 0
total = 0
def bfs(a, b):
    global size
    global eat
    global total
    dx = [0, -1, 0, 1]
    dy = [-1, 0, 1, 0]
    INF = float('inf')
    visited = [[INF for _ in range(N)] for _ in range(N)]
    q = deque([(a, b)])
    visited[a][b] = 0
    tmp = []
    while q:
        x, y = q.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == INF and board[nx][ny] <= size:
                visited[nx][ny] = visited[x][y] + 1
                q.appendleft((nx, ny))
                if 0 < board[nx][ny] < size:
                    tmp.append((visited[nx][ny],nx, ny))
                                
    tmp.sort(key = lambda x: (x[0], x[1], x[2]))
    return tmp
startX, startY = stx, sty
while True:
    tmp = bfs(startX, startY)
    if len(tmp) == 0:
        print(total)
        break
    dist, startX, startY = tmp[0]
    eat += 1
    if eat == size:
        eat = 0
        size += 1
    board[startX][startY] = 0
    total += dist