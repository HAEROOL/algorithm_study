def dfs(depth, idx):
    if depth == 6:
        print(*out)
        return
    for i in range(idx, k):
        out.append(S[i])
        dfs(depth + 1, i + 1)
        out.pop()

while True:
    arr = list(map(int, input().split()))
    k = arr[0]
    S = arr[1:]
    out = []
    dfs(0, 0)
    if k == 0:
        exit()
    print()

