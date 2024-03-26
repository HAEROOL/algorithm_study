from itertools import combinations
from collections import deque

N, M = map(int, input().split())
board = []
chickens = []
houses = []
for x in range(N):
    row = list(map(int, input().split()))
    for y in range(N):
        if row[y] == 2:
            chickens.append((x, y))
        if row[y] == 1:
            houses.append((x,y))

combs = combinations(chickens, M)

def bfs(arr):
    dy = [1, 0, -1, 0]
    dx = [0, 1, 0, -1]
    INF = float('inf')
    visited = [[INF for _ in range(N)]for _ in range(N)]
    for coord in arr:
        visited[coord[0]][coord[1]] = 0
    q = deque(arr)
    while q:
        x, y = q.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] > visited[x][y] + 1:
                visited[nx][ny] = visited[x][y] + 1
                q.appendleft((nx, ny))
    total = 0
    for house in houses:
        x, y = house
        total += visited[x][y]
    return total
answer = float('inf')
for coords in combs:
    answer = min(answer, bfs(coords))
print(answer)