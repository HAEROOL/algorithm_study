from itertools import combinations
from collections import deque
import copy
N, M = map(int, input().split())

matrix = []

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

for _ in range(N):
    matrix.append(list(map(int, input().split())))

walls = []
q = deque()

for x in range(N):
    for y in range(M):
        if matrix[x][y] == 0:
            walls.append((x, y))
        if matrix[x][y] == 2:
            q.append((x, y))

answer = 0
combs = list(combinations(walls, 3))

z = 0
for comb in combs:
    bfsMatrix = copy.deepcopy(matrix)
    bfsQueue = copy.deepcopy(q)
    wall1, wall2, wall3 = comb
    x, y = wall1
    bfsMatrix[x][y] = 1
    x, y = wall2
    bfsMatrix[x][y] = 1
    x, y = wall3
    bfsMatrix[x][y] = 1
    tmp = len(walls) - 3

    while bfsQueue:
        x, y = bfsQueue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and bfsMatrix[nx][ny] == 0:
                bfsMatrix[nx][ny] = 2
                bfsQueue.append((nx, ny))
                tmp -= 1

    answer = max(answer, tmp)
    z += 1
print(answer)
    
