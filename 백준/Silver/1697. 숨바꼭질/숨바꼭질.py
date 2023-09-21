from collections import deque

N, K = map(int, input().split())

q = deque()
q.append(N)
visited = [0 for _ in range(1000000)]
visited[N] = 1

while q:
    p = q.popleft()
    if p == K:
        print(visited[p] - 1)
        break
    
    nx = p + 1
    if 0 <= nx < len(visited) and visited[nx] == 0:
        visited[nx] = visited[p] + 1
        q.append(nx)
    nx = p - 1
    if 0 <= nx < len(visited) and visited[nx] == 0:
        visited[nx] = visited[p] + 1
        q.append(nx)
    nx = p * 2
    if 0 <= nx < len(visited) and visited[nx] == 0:
        visited[nx] = visited[p] + 1
        q.append(nx)