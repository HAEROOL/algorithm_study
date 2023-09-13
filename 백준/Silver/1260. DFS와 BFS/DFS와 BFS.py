N, M, V = map(int, input().split())

graph = [[False] * (N + 1) for _ in range(N + 1)]
for x in range(0, M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

def bfs():
    visited = [False for _ in range(N + 1)]
    queue = [V]
    visited[V] = True
    answer = []
    while queue:
        pointer = queue.pop(0)
        answer.append(pointer)
        for x in range(1, N + 1):
            if not visited[x] and graph[pointer][x]:
                queue.append(x)
                visited[x] = True
    print(*answer)

def dfs():
    visited = [False for _ in range(N + 1)]
    stack = [V]
    answer = []
    while stack:
        pointer = stack.pop()
        if not visited[pointer]:
            visited[pointer] = True
            answer.append(pointer)
        for x in range(N, -1, -1):
            if not visited[x] and graph[pointer][x]:
                stack.append(x)
    print(*answer)

dfs()
bfs()
