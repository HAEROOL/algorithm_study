from collections import deque

N, L, R = map(int, input().split())

board = []
for _ in range(N):
    board.append(list(map(int, input().split())))

def bfs():
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    visited = [[False for _ in range(N)]for _ in range(N)]
    isChanged = False
    for x in range(N):
        for y in range(N):
            if not visited[x][y]:
                q = deque([(x, y)])
                visited[x][y] = True
                visitedList = [(x, y)]
                total = board[x][y]
                while q:
                    a, b = q.pop()
                    for i in range(4):
                        nx = a + dx[i]
                        ny = b + dy[i]
                        if 0 <= nx < N and 0 <= ny < N and L <= abs(board[a][b] - board[nx][ny]) <= R and not visited[nx][ny]:
                            isChanged = True
                            q.appendleft((nx, ny))
                            visited[nx][ny] = True
                            total += board[nx][ny]
                            visitedList.append((nx, ny))
                for a, b in visitedList:
                    board[a][b] = total // len(visitedList)
    return isChanged
answer = 0
while True:
    isChanged = bfs()
    if not isChanged:
        print(answer)
        break
    else:
        answer += 1