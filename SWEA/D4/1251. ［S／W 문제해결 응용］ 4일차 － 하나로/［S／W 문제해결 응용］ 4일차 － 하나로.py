def prim(n):
    D[n] = 0
    U = []
    for _ in range(N):
        mini = float("inf")
        for idx in range(N):
            if  idx in U: continue
            if D[idx] < mini:
                mini = D[idx]
                key = idx
        U.append(key)

        for j in range(N):
            if j in U: continue
            if G[key][j] and G[key][j] < D[j]:
                D[j] = G[key][j]





TC = int(input())

for tc in range(1,TC+1):
    N = int(input())
    X = list(map(int,input().split()))
    Y = list(map(int,input().split()))
    E = float(input())
    G = [[0] * N for _ in range(N)]
    D = [float("inf")] * N
    for i in range(N):
        for j in range(N):
            G[i][j] = (X[i] - X[j])**2 + (Y[i] - Y[j])**2
            G[j][i] = G[i][j]

    prim(0)

    ans = 0
    for elem in D:
        ans += elem
    print('#{} {}'.format(tc, round(ans*E)))