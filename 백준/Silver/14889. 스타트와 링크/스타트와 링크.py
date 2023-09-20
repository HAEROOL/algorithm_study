N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]
visited = [False for i in range(N)]

res = []

def dfs(depth, idx):
    global res
    if depth == N//2:
        A = 0
        B = 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    A += board[i][j]
                elif not visited[i] and not visited[j]:
                    B += board[i][j]
        res.append(abs(A - B))
    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            dfs(depth + 1, i + 1)
            visited[i] = False
dfs(0, 0)
print(min(res))