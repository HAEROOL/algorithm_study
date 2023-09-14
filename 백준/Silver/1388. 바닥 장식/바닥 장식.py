N, M = map(int, input().split())
global visited
global tiles
global answer
answer = 0
tiles = []
visited = [[False for _ in range(M)] for _ in range(N)]

for _ in range(N):
    tiles.append(list(input()))

def dfs(x, y):
    visited[x][y] = True
    if tiles[x][y] == '|':
        if x + 1 < N and tiles[x + 1][y] == '|' and not visited[x + 1][y]:
            dfs(x + 1, y)
        else: return
    if tiles[x][y] == '-':
        if y + 1 < M and tiles[x][y+1] == '-' and not visited[x][y + 1]:
            dfs(x, y + 1)
        else: return
for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            dfs(i, j)
            answer += 1
print(answer)