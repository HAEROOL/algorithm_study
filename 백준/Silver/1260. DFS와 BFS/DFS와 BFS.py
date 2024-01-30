from collections import deque

N, M, V = map(int, input().split())

graph =  [[False for _ in range(N + 1)]for _ in range(N + 1)]

for x in range(M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True


def bfs(v):
    visited = [False for _ in range(N + 1)]
    q = deque([v])
    visited[v] = True
    answer = []
    while q:
        p = q.popleft()
        answer.append(p)
        for x in range(1, N + 1):
            if not visited[x] and graph[p][x]:
                q.append(x)
                visited[x] = True
    print(*answer)

def dfs(v, visited):
    visited[v] = True
    print(v, end=' ')
    
    for x in range(1, N + 1):
        if not visited[x] and graph[v][x]:
            dfs(x, visited)
    
    
dfs(V, [False for _ in range(N + 1)])
print()
bfs(V)
