N, M = map(int, input().split())

arr = list(map(int, input().split()))

arr.sort()

def dfs(depth, idx):
    if depth == M:
        print(*out)
        return
    for i in range(idx, N):
        out.append(arr[i])
        dfs(depth + 1, i + 1)
        out.pop()


out = []
dfs(0, 0)