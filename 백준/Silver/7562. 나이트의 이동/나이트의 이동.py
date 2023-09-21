from collections import deque
TC = int(input())

for _ in range(TC):
    I = int(input())
    start = list(map(int, input().split()))
    target = list(map(int, input().split()))

    direction = [(2, 1), (1, 2), (-1, 2), (-2, 1), (-2, -1), (-1, -2), (1, -2), (2, -1)]
    visited = [[0 for _ in range(I)] for _ in range(I)]

    q = deque()
    q.append((start[0],start[1]))
    visited[start[0]][start[1]] = 1

    while q:
        a, b = q.popleft()
        if a == target[0] and b == target[1]:
            print(visited[a][b] - 1)
        for dir in direction:
            dx, dy = dir
            nx = a + dx
            ny = b + dy
            if 0 <= nx < I and 0 <= ny < I and visited[nx][ny] == 0:
                q.append((nx, ny))
                visited[nx][ny] = visited[a][b] + 1
